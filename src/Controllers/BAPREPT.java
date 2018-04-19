/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import be.quodlibet.boxable.BaseTable;
import be.quodlibet.boxable.Cell;
import be.quodlibet.boxable.Row;
import be.quodlibet.boxable.utils.PDStreamUtils;
import data.DataManagerImpl;
import domain.Customer;
import domain.JobLine;
import domain.OrderTable;
import domain.TaskLine;
        
import domain.TaskLine;
import java.awt.Color;
import java.awt.print.PrinterException;
import java.io.IOException;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.PDPageContentStream.AppendMode;
import org.apache.pdfbox.pdmodel.common.PDRectangle;
import org.apache.pdfbox.pdmodel.font.PDFont;
import org.apache.pdfbox.pdmodel.font.PDType1Font;
import print.DocPrinter;

/**
 *
 * @author Daniel
 */
public class BAPREPT {
    
    long copyd1 = 0;
        long developmentd1 = 0; 
        long packingd1 = 0;
        long finishingd1 = 0;
        long copyd2 = 0;
        long developmentd2 = 0; 
        long packingd2 = 0;
        long finishingd2 = 0;
        long copyn = 0;
        long developmentn = 0; 
        long packingn = 0;
        long finishingn = 0;
        long copyd1Total = 0;
        long packingd1Total = 0;
        long developmentd1Total = 0;
        long finishingd1Total = 0;
        long copyd2Total = 0;
        long developmentd2Total = 0;
        long packingd2Total = 0;
        long finishingd2Total = 0;
        long copynTotal = 0;
        long developmentnTotal = 0;
        long packingnTotal = 0;
        long finishingnTotal = 0;
        long copyTotal = 0;
        long developmentTotal = 0;
        long packingTotal = 0;
        long finishingTotal = 0;
        
       
                
        List<String[]> listd1 = new ArrayList<String[]>();
        List<String[]> listd2 = new ArrayList<String[]>();
        List<String[]> listn = new ArrayList<String[]>();
        List<String[]> listTotal = new ArrayList<String[]>();

    public BAPREPT() {
    }

    public void createIndividualReport(String date1, String date2) throws IOException, PrinterException {
        String day1 = date1.substring(0, 2);
        String month1 = date1.substring(3, 5);
        String year1 = date1.substring(6, 10);
        String newDate1 = year1 + "-" + month1 + "-" + day1;
        String day2 = date2.substring(0, 2);
        String month2 = date2.substring(3, 5);
        String year2 = date2.substring(6, 10);
        String newDate2 = year2 + "-" + month2 + "-" + day2;
        PDPage page = new PDPage(PDRectangle.A4);
        PDDocument doc = new PDDocument();
        PDPageContentStream contentStream = new PDPageContentStream(doc, page);
        float hWidth = page.getMediaBox().getWidth() / 4;
        double a = page.getMediaBox().getWidth() / 2.65;
        float hWidth2 = (float) a;
        PDFont font = PDType1Font.HELVETICA_BOLD;
        PDFont font2 = PDType1Font.HELVETICA;
        String period = "Period: " + date1 + " - " + date2;
        PDStreamUtils.write(contentStream, "Summary Report", font, 20, hWidth, 790, Color.BLACK);
        PDStreamUtils.write(contentStream, period, font2, 15, hWidth2, 750, Color.BLACK);

        float margin = 50;
        float yStartNewPage = page.getMediaBox().getHeight() - (2 * margin);
        float tableWidth = page.getMediaBox().getWidth() - (2 * margin);

        float bottomMargin = 70;
        float yPosition = 700;
        BaseTable table = new BaseTable(yPosition, yStartNewPage, bottomMargin, tableWidth, margin, doc, page, true, true);
//Create Header row
        DataManagerImpl dm = new DataManagerImpl();
        List<TaskLine> line = dm.individualReportBetween(Date.valueOf(newDate1), Date.valueOf(newDate2));
        List<String[]> list = new ArrayList<String[]>();
        SimpleDateFormat localDateFormat = new SimpleDateFormat("HH:mm");
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        SimpleDateFormat form = new SimpleDateFormat("HH:mm");
        long j = 0;
        long total = 0;

        for (int i = 0; i < line.size(); i++) {
            TaskLine g = line.get(i);

            String[] sdot = new String[8];
            sdot[0] = g.getCompletedBy().getForename() + " " + g.getCompletedBy().getSurname();
            sdot[1] = g.getJoblineID().getJobCode().getCode();
            sdot[2] = Integer.toString(g.getTaskID().getTaskID());
            sdot[3] = g.getTaskID().getDepartment();
            sdot[4] = formatter.format(g.getEndTime());
            sdot[5] = localDateFormat.format(g.getStartTime());
            // java.util.Date  e = new Date(g.getEndTime().getTime() - g.getStartTime().getTime());
            long e = g.getEndTime().getTime() - g.getStartTime().getTime();
            int seconds = (int) ((e / 1000) % 60);
            int minutes = (int) ((e / (1000 * 60)) % 60);
            int hours = (int) ((e / (1000 * 60 * 60)) % 24);

            if (hours > 0) {
                sdot[6] = hours + "h" + minutes + "min";
            } else {
                sdot[6] = minutes + "min";
            }

            if (i + 1 < line.size()) {
                if (line.get(i + 1) != null) {
                    if (g.getCompletedBy().getUsername().compareTo(line.get(i + 1).getCompletedBy().getUsername()) == 0) {
                        j = j + e;
                        total += e;

                    } else {
                        if (j == 0) {
                            if (hours > 0) {
                                sdot[7] = hours + "h" + minutes + "min";
                                total += e;
                            } else {
                                sdot[7] = minutes + "min";
                                total += e;
                            }
                        } else {
                            j += e;
                            total += e;

                            hours = (int) ((j / (1000 * 60 * 60)) % 24);

                            minutes = (int) ((j / (1000 * 60)) % 60);

                            if (hours > 0) {
                                sdot[7] = hours + "h" + minutes + "min";
                            } else {
                                sdot[7] = minutes + "min";
                            }
                            j = 0;
                        }
                    }

                }

            } else if (j != 0) {
                j += e;
                total += e;

                hours = (int) ((j / (1000 * 60 * 60)) % 24);

                minutes = (int) ((j / (1000 * 60)) % 60);

                if (hours > 0) {
                    sdot[7] = hours + "h" + minutes + "min";
                } else {
                    sdot[7] = minutes + "min";
                }
                j = 0;
            }

            list.add(sdot);

            System.out.println(g.getCompletedBy().getForename() + " " + g.getCompletedBy().getSurname() + " " + g.getTaskID().getTaskID() + " " + g.getJoblineID().getJobCode().getCode() + " " + localDateFormat.format(g.getStartTime()) + " " + formatter.format(g.getEndTime()));
        }

        Row<PDPage> titleRow = table.createRow(15f);
        Cell<PDPage> cell = titleRow.createCell(100, "Individual Report");
        cell.setFont(PDType1Font.HELVETICA_BOLD);
        cell.setFillColor(Color.WHITE);
        table.addHeaderRow(titleRow);

        Row<PDPage> headerRow = table.createRow(15f);
        Cell<PDPage> cell2 = headerRow.createCell(100 / 8f, "Name");
        cell2.setFont(PDType1Font.HELVETICA_BOLD);
        Cell<PDPage> cell3 = headerRow.createCell(100 / 8f, "Job Code");
        cell3.setFont(PDType1Font.HELVETICA_BOLD);
        Cell<PDPage> cell4 = headerRow.createCell(100 / 8f, "Task IDs");
        cell4.setFont(PDType1Font.HELVETICA_BOLD);
        Cell<PDPage> cell5 = headerRow.createCell(100 / 8f, "Department");
        cell5.setFont(PDType1Font.HELVETICA_BOLD);
        Cell<PDPage> cell6 = headerRow.createCell(100 / 8f, "Date");
        cell6.setFont(PDType1Font.HELVETICA_BOLD);
        Cell<PDPage> cell7 = headerRow.createCell(100 / 8f, "Start Time");
        cell7.setFont(PDType1Font.HELVETICA_BOLD);
        Cell<PDPage> cell8 = headerRow.createCell(100 / 8f, "Time Taken");
        cell8.setFont(PDType1Font.HELVETICA_BOLD);
        Cell<PDPage> cell9 = headerRow.createCell(100 / 8f, "Total");
        cell9.setFont(PDType1Font.HELVETICA_BOLD);
        cell.setFont(PDType1Font.HELVETICA_BOLD);
        cell.setFillColor(Color.WHITE);
        table.addHeaderRow(headerRow);

        for (String[] fact : list) {
            Row<PDPage> row = table.createRow(10f);
            cell = row.createCell((100 / 8f), fact[0]);
            for (int i = 1; i < fact.length; i++) {
                cell = row.createCell((100 / 8f), fact[i]);
            }
        }
        int minutes = (int) ((total / (1000 * 60)) % 60);
        int hours = (int) ((total / (1000 * 60 * 60)) % 24);
        Row<PDPage> footerRow = table.createRow(15f);
        Cell<PDPage> cell10 = footerRow.createCell((100 / 8f) * 7, "Total effort");
        cell10.setFont(PDType1Font.HELVETICA_BOLD);
        String totalString = hours + "h " + minutes + "min ";
        Cell<PDPage> cell11 = footerRow.createCell((100 / 8f), totalString);
        cell10.setFont(PDType1Font.HELVETICA_BOLD);

        int p = 5 * 8;
        table.draw();
        contentStream.close();
        doc.addPage(page);
        doc.save(day1 + "_" + month1 + "_" + year1 + "_-_" + day2 + "_" + month2 + "_" + year2 + "_" + "Individualreport.pdf");
        DocPrinter dp = new DocPrinter();
        dp.printFile(doc);
        doc.close();
    }

    public void createYearlyReport(String date1, String date2) throws IOException, PrinterException {
        String day1 = date1.substring(0, 2);
        String month1 = date1.substring(3, 5);
        String year1 = date1.substring(6, 10);
        String newDate1 = year1 + "-" + month1 + "-" + day1;
        String day2 = date2.substring(0, 2);
        String month2 = date2.substring(3, 5);
        String year2 = date2.substring(6, 10);
        String newDate2 = year2 + "-" + month2 + "-" + day2;
        PDPage page = new PDPage(PDRectangle.A4);
        PDDocument doc = new PDDocument();
        PDPageContentStream contentStream = new PDPageContentStream(doc, page);
        float hWidth = page.getMediaBox().getWidth() / 4;
        double a = page.getMediaBox().getWidth() / 2.45;
        float hWidth2 = (float) a;
        PDFont font = PDType1Font.HELVETICA_BOLD;
        PDFont font2 = PDType1Font.HELVETICA;
        String period = "Period: " + year1;
        PDStreamUtils.write(contentStream, "Individual Performance Report", font, 20, hWidth, 790, Color.BLACK);
        PDStreamUtils.write(contentStream, period, font2, 15, hWidth2, 750, Color.BLACK);

        float margin = 50;
        float yStartNewPage = page.getMediaBox().getHeight() - (2 * margin);
        float tableWidth = page.getMediaBox().getWidth() - (2 * margin);

        float bottomMargin = 70;
        float yPosition = 700;
        BaseTable table = new BaseTable(yPosition, yStartNewPage, bottomMargin, tableWidth, margin, doc, page, true, true);
//Create Header row
        DataManagerImpl dm = new DataManagerImpl();
        List<TaskLine> line = dm.individualReportBetween(Date.valueOf(newDate1), Date.valueOf(newDate2));
        List<String[]> list = new ArrayList<String[]>();
        SimpleDateFormat localDateFormat = new SimpleDateFormat("HH:mm");
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        SimpleDateFormat form = new SimpleDateFormat("HH:mm");
        long j = 0;
        long total = 0;

        for (int i = 0; i < line.size(); i++) {
            TaskLine g = line.get(i);

            String[] sdot = new String[8];
            sdot[0] = g.getCompletedBy().getForename() + " " + g.getCompletedBy().getSurname();
            sdot[1] = g.getJoblineID().getJobCode().getCode();
            sdot[2] = Integer.toString(g.getTaskID().getTaskID());
            sdot[3] = g.getTaskID().getDepartment();
            sdot[4] = formatter.format(g.getEndTime());
            sdot[5] = localDateFormat.format(g.getStartTime());
            // java.util.Date  e = new Date(g.getEndTime().getTime() - g.getStartTime().getTime());
            long e = g.getEndTime().getTime() - g.getStartTime().getTime();
            int seconds = (int) ((e / 1000) % 60);
            int minutes = (int) ((e / (1000 * 60)) % 60);
            int hours = (int) ((e / (1000 * 60 * 60)) % 24);

            if (hours > 0) {
                sdot[6] = hours + "h" + minutes + "min";
            } else {
                sdot[6] = minutes + "min";
            }

            if (i + 1 < line.size()) {
                if (line.get(i + 1) != null) {
                    if (g.getCompletedBy().getUsername().compareTo(line.get(i + 1).getCompletedBy().getUsername()) == 0) {
                        j = j + e;
                        total += e;

                    } else {
                        if (j == 0) {
                            total += e;
                            if (hours > 0) {
                                sdot[7] = hours + "h" + minutes + "min";

                            } else {
                                sdot[7] = minutes + "min";
                            }
                        } else {
                            j += e;
                            total += e;

                            hours = (int) ((j / (1000 * 60 * 60)) % 24);

                            minutes = (int) ((j / (1000 * 60)) % 60);

                            if (hours > 0) {
                                sdot[7] = hours + "h" + minutes + "min";
                            } else {
                                sdot[7] = minutes + "min";
                            }
                            j = 0;
                        }
                    }

                }

            } else if (j != 0) {
                j += e;
                total += e;

                hours = (int) ((j / (1000 * 60 * 60)) % 24);

                minutes = (int) ((j / (1000 * 60)) % 60);

                if (hours > 0) {
                    sdot[7] = hours + "h" + minutes + "min";
                } else {
                    sdot[7] = minutes + "min";
                }
                j = 0;
            }

            list.add(sdot);

           // System.out.println(g.getCompletedBy().getForename() + " " + g.getCompletedBy().getSurname() + " " + g.getTaskID().getTaskID() + " " + g.getJoblineID().getJobCode().getCode() + " " + localDateFormat.format(g.getStartTime()) + " " + formatter.format(g.getEndTime()));
        }

        Row<PDPage> titleRow = table.createRow(15f);
        Cell<PDPage> cell = titleRow.createCell(100, "Individual Report");
        cell.setFont(PDType1Font.HELVETICA_BOLD);
        cell.setFillColor(Color.WHITE);
        table.addHeaderRow(titleRow);

        Row<PDPage> headerRow = table.createRow(15f);
        Cell<PDPage> cell2 = headerRow.createCell(100 / 8f, "Name");
        cell2.setFont(PDType1Font.HELVETICA_BOLD);
        Cell<PDPage> cell3 = headerRow.createCell(100 / 8f, "Job Code");
        cell3.setFont(PDType1Font.HELVETICA_BOLD);
        Cell<PDPage> cell4 = headerRow.createCell(100 / 8f, "Task IDs");
        cell4.setFont(PDType1Font.HELVETICA_BOLD);
        Cell<PDPage> cell5 = headerRow.createCell(100 / 8f, "Department");
        cell5.setFont(PDType1Font.HELVETICA_BOLD);
        Cell<PDPage> cell6 = headerRow.createCell(100 / 8f, "Date");
        cell6.setFont(PDType1Font.HELVETICA_BOLD);
        Cell<PDPage> cell7 = headerRow.createCell(100 / 8f, "Start Time");
        cell7.setFont(PDType1Font.HELVETICA_BOLD);
        Cell<PDPage> cell8 = headerRow.createCell(100 / 8f, "Time Taken");
        cell8.setFont(PDType1Font.HELVETICA_BOLD);
        Cell<PDPage> cell9 = headerRow.createCell(100 / 8f, "Total");
        cell9.setFont(PDType1Font.HELVETICA_BOLD);
        cell.setFont(PDType1Font.HELVETICA_BOLD);
        cell.setFillColor(Color.WHITE);
        table.addHeaderRow(headerRow);

        for (String[] fact : list) {
            
            if (table.getCurrentPage() != page) {
                doc.addPage(page);
                contentStream.close();
                page = table.getCurrentPage();
                contentStream = new PDPageContentStream(doc, page, AppendMode.APPEND, false);

                contentStream.beginText();
            }
            Row<PDPage> row = table.createRow(10f);
            cell = row.createCell((100 / 8f), fact[0]);
            for (int i = 1; i < fact.length; i++) {
                cell = row.createCell((100 / 8f), fact[i]);
            }
        }

        int minutes = (int) ((total / (1000 * 60)) % 60);
        int hours = (int) ((total / (1000 * 60 * 60)) % 24);
        Row<PDPage> footerRow = table.createRow(15f);
        Cell<PDPage> cell10 = footerRow.createCell((100 / 8f) * 7, "Total effort");
        cell10.setFont(PDType1Font.HELVETICA_BOLD);
        String totalString = hours + "h " + minutes + "min ";
        Cell<PDPage> cell11 = footerRow.createCell((100 / 8f), totalString);
        cell11.setFont(PDType1Font.HELVETICA_BOLD);

        int p = 5 * 8;
        doc.addPage(page);
        table.draw();
        contentStream.close();
        doc.save(year1 + "_" + "Individualreport.pdf");
        DocPrinter dp = new DocPrinter();
        dp.printFile(doc);
        doc.close();
    }

    public void createQuarterlyReport(String date1, String date2, String quarter, String q) throws IOException, PrinterException {
        String day1 = date1.substring(0, 2);
        String month1 = date1.substring(3, 5);
        String year1 = date1.substring(6, 10);
        String newDate1 = year1 + "-" + month1 + "-" + day1;
        String day2 = date2.substring(0, 2);
        String month2 = date2.substring(3, 5);
        String year2 = date2.substring(6, 10);
        String newDate2 = year2 + "-" + month2 + "-" + day2;
        PDPage page = new PDPage(PDRectangle.A4);
        PDDocument doc = new PDDocument();
        PDPageContentStream contentStream = new PDPageContentStream(doc, page);
        float hWidth = page.getMediaBox().getWidth() / 4;
        double a = page.getMediaBox().getWidth() / 2.65;
        float hWidth2 = (float) a;
        PDFont font = PDType1Font.HELVETICA_BOLD;
        PDFont font2 = PDType1Font.HELVETICA;
        String period = q + " Report" + " " + year1;
        PDStreamUtils.write(contentStream, "Individual Performance Report", font, 20, hWidth, 790, Color.BLACK);
        PDStreamUtils.write(contentStream, period, font2, 15, hWidth2, 750, Color.BLACK);

        float margin = 50;
        float yStartNewPage = page.getMediaBox().getHeight() - (2 * margin);
        float tableWidth = page.getMediaBox().getWidth() - (2 * margin);

        float bottomMargin = 70;
        float yPosition = 700;
        BaseTable table = new BaseTable(yPosition, yStartNewPage, bottomMargin, tableWidth, margin, doc, page, true, true);
//Create Header row
        DataManagerImpl dm = new DataManagerImpl();
        List<TaskLine
                > line = dm.individualReportBetween(Date.valueOf(newDate1), Date.valueOf(newDate2));
        List<String[]> list = new ArrayList<String[]>();
        SimpleDateFormat localDateFormat = new SimpleDateFormat("HH:mm");
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        SimpleDateFormat form = new SimpleDateFormat("HH:mm");
        long j = 0;
        long total = 0;

        for (int i = 0; i < line.size(); i++) {
            TaskLine
                    g = line.get(i);

            String[] sdot = new String[8];
            sdot[0] = g.getCompletedBy().getForename() + " " + g.getCompletedBy().getSurname();
            sdot[1] = g.getJoblineID().getJobCode().getCode();
            sdot[2] = Integer.toString(g.getTaskID().getTaskID());
            sdot[3] = g.getTaskID().getDepartment();
            sdot[4] = formatter.format(g.getEndTime());
            sdot[5] = localDateFormat.format(g.getStartTime());
            // java.util.Date  e = new Date(g.getEndTime().getTime() - g.getStartTime().getTime());
            long e = g.getEndTime().getTime() - g.getStartTime().getTime();
            int seconds = (int) ((e / 1000) % 60);
            int minutes = (int) ((e / (1000 * 60)) % 60);
            int hours = (int) ((e / (1000 * 60 * 60)) % 24);

            if (hours > 0) {
                sdot[6] = hours + "h" + minutes + "min";
            } else {
                sdot[6] = minutes + "min";
            }

            if (i + 1 < line.size()) {
                if (line.get(i + 1) != null) {
                    if (g.getCompletedBy().getUsername().compareTo(line.get(i + 1).getCompletedBy().getUsername()) == 0) {
                        j = j + e;
                        total += e;

                    } else {
                        if (j == 0) {
                            if (hours > 0) {
                                total += e;
                                sdot[7] = hours + "h" + minutes + "min";
                            } else {
                                sdot[7] = minutes + "min";
                            }
                        } else {
                            j += e;
                            total += e;

                            hours = (int) ((j / (1000 * 60 * 60)) % 24);

                            minutes = (int) ((j / (1000 * 60)) % 60);

                            if (hours > 0) {
                                sdot[7] = hours + "h" + minutes + "min";
                            } else {
                                sdot[7] = minutes + "min";
                            }
                            j = 0;
                        }
                    }

                }

            } else if (j != 0) {
                j += e;
                total += e;

                hours = (int) ((j / (1000 * 60 * 60)) % 24);

                minutes = (int) ((j / (1000 * 60)) % 60);

                if (hours > 0) {
                    sdot[7] = hours + "h" + minutes + "min";
                } else {
                    sdot[7] = minutes + "min";
                }
                j = 0;
            }

            list.add(sdot);

            System.out.println(g.getCompletedBy().getForename() + " " + g.getCompletedBy().getSurname() + " " + g.getTaskID().getTaskID() + " " + g.getJoblineID().getJobCode().getCode() + " " + localDateFormat.format(g.getStartTime()) + " " + formatter.format(g.getEndTime()));
        }

        Row<PDPage> titleRow = table.createRow(15f);
        Cell<PDPage> cell = titleRow.createCell(100, "Individual Report");
        cell.setFont(PDType1Font.HELVETICA_BOLD);
        cell.setFillColor(Color.WHITE);
        table.addHeaderRow(titleRow);

        Row<PDPage> headerRow = table.createRow(15f);
        Cell<PDPage> cell2 = headerRow.createCell(100 / 8f, "Name");
        cell2.setFont(PDType1Font.HELVETICA_BOLD);
        Cell<PDPage> cell3 = headerRow.createCell(100 / 8f, "Job Code");
        cell3.setFont(PDType1Font.HELVETICA_BOLD);
        Cell<PDPage> cell4 = headerRow.createCell(100 / 8f, "Task IDs");
        cell4.setFont(PDType1Font.HELVETICA_BOLD);
        Cell<PDPage> cell5 = headerRow.createCell(100 / 8f, "Department");
        cell5.setFont(PDType1Font.HELVETICA_BOLD);
        Cell<PDPage> cell6 = headerRow.createCell(100 / 8f, "Date");
        cell6.setFont(PDType1Font.HELVETICA_BOLD);
        Cell<PDPage> cell7 = headerRow.createCell(100 / 8f, "Start Time");
        cell7.setFont(PDType1Font.HELVETICA_BOLD);
        Cell<PDPage> cell8 = headerRow.createCell(100 / 8f, "Time Taken");
        cell8.setFont(PDType1Font.HELVETICA_BOLD);
        Cell<PDPage> cell9 = headerRow.createCell(100 / 8f, "Total");
        cell9.setFont(PDType1Font.HELVETICA_BOLD);
        cell.setFont(PDType1Font.HELVETICA_BOLD);
        cell.setFillColor(Color.WHITE);
        table.addHeaderRow(headerRow);

        for (String[] fact : list) {
            
            

            if (table.getCurrentPage() != page) {
                doc.addPage(page);
                contentStream.close();
                page = table.getCurrentPage();
                contentStream = new PDPageContentStream(doc, page, AppendMode.APPEND, false);

                contentStream.beginText();
            }

            Row<PDPage> row = table.createRow(10f);
            cell = row.createCell((100 / 8f), fact[0]);
            for (int i = 1; i < fact.length; i++) {
                cell = row.createCell((100 / 8f), fact[i]);
            }
        }

        int minutes = (int) ((total / (1000 * 60)) % 60);
        int hours = (int) ((total / (1000 * 60 * 60)) % 24);
        Row<PDPage> footerRow = table.createRow(15f);
        Cell<PDPage> cell10 = footerRow.createCell((100 / 8f) * 7, "Total effort");
        cell10.setFont(PDType1Font.HELVETICA_BOLD);
        String totalString = hours + "h " + minutes + "min ";
        Cell<PDPage> cell11 = footerRow.createCell((100 / 8f), totalString);
        cell11.setFont(PDType1Font.HELVETICA_BOLD);

        int p = 5 * 8;
        contentStream.close();
        doc.addPage(page);
        table.draw();
        doc.save(year1 + "_" + quarter + "_Individual_report.pdf");
        DocPrinter dp = new DocPrinter();
        dp.printFile(doc);
        doc.close();
    }

    public void createMonthlyReport(String date1, String date2) throws IOException, PrinterException {
        
        //Reconstruct Inputed dates to Date format
        String day1 = date1.substring(0, 2);
        String month1 = date1.substring(3, 5);
        String year1 = date1.substring(6, 10);
        String newDate1 = year1 + "-" + month1 + "-" + day1;
        String day2 = date2.substring(0, 2);
        String month2 = date2.substring(3, 5);
        String year2 = date2.substring(6, 10);
        String newDate2 = year2 + "-" + month2 + "-" + day2;
        
        
        SimpleDateFormat monthFormat = new SimpleDateFormat("MMMM");
        String monthName = monthFormat.format(Date.valueOf(newDate1));
        
        
        //Create PDF document and set header
        PDPage page = new PDPage(PDRectangle.A4);
        PDDocument doc = new PDDocument();
        PDPageContentStream contentStream = new PDPageContentStream(doc, page);
        float hWidth = page.getMediaBox().getWidth() / 4;
        double a = page.getMediaBox().getWidth() / 2.65;
        float hWidth2 = (float) a;
        PDFont font = PDType1Font.HELVETICA_BOLD;
        PDFont font2 = PDType1Font.HELVETICA;
        String period = "Period: " + monthName;
        PDStreamUtils.write(contentStream, "Individual Performance Report", font, 20, hWidth, 790, Color.BLACK);
        PDStreamUtils.write(contentStream, period, font2, 15, hWidth2, 750 , Color.BLACK);
        // Define table properties
        float margin = 50;
        float yStartNewPage = page.getMediaBox().getHeight() - (2 * margin);
        float tableWidth = page.getMediaBox().getWidth() - (2 * margin);

        float bottomMargin = 70;
        float yPosition = 700;
        BaseTable table = new BaseTable(yPosition, yStartNewPage, bottomMargin, tableWidth, margin, doc, page, true, true);
        
// Search for TaskLines between a given period and place in a list
        DataManagerImpl dm = new DataManagerImpl();
        List<TaskLine> line = dm.individualReportBetween(Date.valueOf(newDate1), Date.valueOf(newDate2));
        // create array list of Strings to feed into the table
        List<String[]> list = new ArrayList<String[]>();
        
        //Set up date formats and hours and minutes formats
        SimpleDateFormat localDateFormat = new SimpleDateFormat("HH:mm");
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        SimpleDateFormat form = new SimpleDateFormat("HH:mm");
        // create variable to total up hours
        long j = 0;
        long total = 0;
        
        //Go through TaskLine list and copy properties into arraylist

        for (int i = 0; i < line.size(); i++) {
            TaskLine g = line.get(i);

            String[] sdot = new String[8];
            sdot[0] = g.getCompletedBy().getForename() + " " + g.getCompletedBy().getSurname();
            sdot[1] = g.getJoblineID().getJobCode().getCode();
            sdot[2] = Integer.toString(g.getTaskID().getTaskID());
            sdot[3] = g.getTaskID().getDepartment();
            sdot[4] = formatter.format(g.getEndTime());
            sdot[5] = localDateFormat.format(g.getStartTime());
            // java.util.Date  e = new Date(g.getEndTime().getTime() - g.getStartTime().getTime());
            long e = g.getEndTime().getTime() - g.getStartTime().getTime();
            int seconds = (int) ((e / 1000) % 60);
            int minutes = (int) ((e / (1000 * 60)) % 60);
            int hours = (int) ((e / (1000 * 60 * 60)) % 24);

            if (hours > 0) {
                sdot[6] = hours + "h" + minutes + "min";
            } else {
                sdot[6] = minutes + "min";
            }

            if (i + 1 < line.size()) {
                if (line.get(i + 1) != null) {
                    if (g.getCompletedBy().getUsername().compareTo(line.get(i + 1).getCompletedBy().getUsername()) == 0) {
                        j = j + e;
                        total += e;

                    } else {
                        if (j == 0) {
                            total += e;

                            if (hours > 0) {
                                sdot[7] = hours + "h" + minutes + "min";
                            } else {
                                sdot[7] = minutes + "min";
                            }
                        } else {
                            j += e;
                            total += e;

                            hours = (int) ((j / (1000 * 60 * 60)) % 24);

                            minutes = (int) ((j / (1000 * 60)) % 60);

                            if (hours > 0) {
                                sdot[7] = hours + "h" + minutes + "min";
                            } else {
                                sdot[7] = minutes + "min";
                            }
                            j = 0;
                        }
                    }

                }

            } else if (j != 0) {
                j += e;
                total += e;

                hours = (int) ((j / (1000 * 60 * 60)) % 24);

                minutes = (int) ((j / (1000 * 60)) % 60);

                if (hours > 0) {
                    sdot[7] = hours + "h" + minutes + "min";
                } else {
                    sdot[7] = minutes + "min";
                }
                j = 0;
            }

            list.add(sdot);

            System.out.println(g.getCompletedBy().getForename() + " " + g.getCompletedBy().getSurname() + " " + g.getTaskID().getTaskID() + " " + g.getJoblineID().getJobCode().getCode() + " " + localDateFormat.format(g.getStartTime()) + " " + formatter.format(g.getEndTime()));
        }
        
        // Draw Table
        // Draw first 2 rows

        Row<PDPage> titleRow = table.createRow(15f);
        Cell<PDPage> cell = titleRow.createCell(100, "Individual Report");
        cell.setFont(PDType1Font.HELVETICA_BOLD);
        cell.setFillColor(Color.WHITE);
        table.addHeaderRow(titleRow);

        Row<PDPage> headerRow = table.createRow(15f);
        Cell<PDPage> cell2 = headerRow.createCell(100 / 8f, "Name");
        cell2.setFont(PDType1Font.HELVETICA_BOLD);
        Cell<PDPage> cell3 = headerRow.createCell(100 / 8f, "Job Code");
        cell3.setFont(PDType1Font.HELVETICA_BOLD);
        Cell<PDPage> cell4 = headerRow.createCell(100 / 8f, "Task IDs");
        cell4.setFont(PDType1Font.HELVETICA_BOLD);
        Cell<PDPage> cell5 = headerRow.createCell(100 / 8f, "Department");
        cell5.setFont(PDType1Font.HELVETICA_BOLD);
        Cell<PDPage> cell6 = headerRow.createCell(100 / 8f, "Date");
        cell6.setFont(PDType1Font.HELVETICA_BOLD);
        Cell<PDPage> cell7 = headerRow.createCell(100 / 8f, "Start Time");
        cell7.setFont(PDType1Font.HELVETICA_BOLD);
        Cell<PDPage> cell8 = headerRow.createCell(100 / 8f, "Time Taken");
        cell8.setFont(PDType1Font.HELVETICA_BOLD);
        Cell<PDPage> cell9 = headerRow.createCell(100 / 8f, "Total");
        cell9.setFont(PDType1Font.HELVETICA_BOLD);
        cell.setFont(PDType1Font.HELVETICA_BOLD);
        cell.setFillColor(Color.WHITE);
        table.addHeaderRow(headerRow);
        
        // pupulate the rest of the table with ArrayList of string

        for (String[] fact : list) {
            
            if (table.getCurrentPage() != page) {
                doc.addPage(page);
                contentStream.close();
                page = table.getCurrentPage();
                contentStream = new PDPageContentStream(doc, page, AppendMode.APPEND, false);

                contentStream.beginText();
            }
            Row<PDPage> row = table.createRow(10f);
            cell = row.createCell((100 / 8f), fact[0]);
            for (int i = 1; i < fact.length; i++) {
                cell = row.createCell((100 / 8f), fact[i]);
            }
        }
        
        // convert total time in milliseconds to minutes and hours

        int minutes = (int) ((total / (1000 * 60)) % 60);
        int hours = (int) ((total / (1000 * 60 * 60)) % 24);
        Row<PDPage> footerRow = table.createRow(15f);
        Cell<PDPage> cell10 = footerRow.createCell((100 / 8f) * 7, "Total effort");
        cell10.setFont(PDType1Font.HELVETICA_BOLD);
        String totalString = hours + "h " + minutes + "min ";
        Cell<PDPage> cell11 = footerRow.createCell((100 / 8f), totalString);
        cell11.setFont(PDType1Font.HELVETICA_BOLD);
        
        //close content stream
        contentStream.close();
        doc.addPage(page);
        table.draw();
        //save document
        doc.save(monthName + "_" + "Individualreport.pdf");
        DocPrinter dp = new DocPrinter();
        dp.printFile(doc);
        doc.close();
    }

    public void createIndividualReportSingleDate(String date) throws IOException {
        String day = date.substring(0, 2);
        String month = date.substring(3, 5);
        String year = date.substring(6, 10);
        String newDate = year + "-" + month + "-" + day;
        PDPage page = new PDPage(PDRectangle.A4);
        PDDocument doc = new PDDocument();
        PDPageContentStream contentStream = new PDPageContentStream(doc, page);
        float hWidth = page.getMediaBox().getWidth() / 4;
        double a = page.getMediaBox().getWidth() / 2.65;
        float hWidth2 = (float) a;
        PDFont font = PDType1Font.HELVETICA_BOLD;
        PDFont font2 = PDType1Font.HELVETICA;
        String period = "Date: " + date;
        PDStreamUtils.write(contentStream, "Individual Performance Report", font, 20, hWidth, 790, Color.BLACK);
        PDStreamUtils.write(contentStream, period, font2, 15, hWidth2, 750, Color.BLACK);

        float margin = 50;
        float yStartNewPage = page.getMediaBox().getHeight() - (2 * margin);
        float tableWidth = page.getMediaBox().getWidth() - (2 * margin);

        float bottomMargin = 70;
        float yPosition = 700;
        BaseTable table = new BaseTable(yPosition, yStartNewPage, bottomMargin, tableWidth, margin, doc, page, true, true);
//Create Header row
        DataManagerImpl dm = new DataManagerImpl();
        List<TaskLine
                > line = dm.individualReport(Date.valueOf(newDate));
        List<String[]> list = new ArrayList<String[]>();
        SimpleDateFormat localDateFormat = new SimpleDateFormat("HH:mm");
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        SimpleDateFormat form = new SimpleDateFormat("HH:mm");
        long j = 0;

        for (int i = 0; i < line.size(); i++) {
            TaskLine
                    g = line.get(i);

            String[] sdot = new String[8];
            sdot[0] = g.getCompletedBy().getForename() + " " + g.getCompletedBy().getSurname();
            sdot[1] = g.getJoblineID().getJobCode().getCode();
            sdot[2] = Integer.toString(g.getTaskID().getTaskID());
            sdot[3] = g.getTaskID().getDepartment();
            sdot[4] = formatter.format(g.getEndTime());
            sdot[5] = localDateFormat.format(g.getStartTime());
            // java.util.Date  e = new Date(g.getEndTime().getTime() - g.getStartTime().getTime());
            long e = g.getEndTime().getTime() - g.getStartTime().getTime();
            int seconds = (int) ((e / 1000) % 60);
            int minutes = (int) ((e / (1000 * 60)) % 60);
            int hours = (int) ((e / (1000 * 60 * 60)) % 24);

            if (hours > 0) {
                sdot[6] = hours + "h" + minutes + "min";
            } else {
                sdot[6] = minutes + "min";
            }

            if (i + 1 < line.size()) {
                if (line.get(i + 1) != null) {
                    if (g.getCompletedBy().getUsername().compareTo(line.get(i + 1).getCompletedBy().getUsername()) == 0) {
                        j = j + e;

                    } else {
                        if (j == 0) {
                            if (hours > 0) {
                                sdot[7] = hours + "h" + minutes + "min";
                            } else {
                                sdot[7] = minutes + "min";
                            }
                        } else {
                            j += e;

                            hours = (int) ((j / (1000 * 60 * 60)) % 24);

                            minutes = (int) ((j / (1000 * 60)) % 60);

                            if (hours > 0) {
                                sdot[7] = hours + "h" + minutes + "min";
                            } else {
                                sdot[7] = minutes + "min";
                            }
                            j = 0;
                        }
                    }

                }

            } else if (j != 0) {
                j += e;

                hours = (int) ((j / (1000 * 60 * 60)) % 24);

                minutes = (int) ((j / (1000 * 60)) % 60);

                if (hours > 0) {
                    sdot[7] = hours + "h" + minutes + "min";
                } else {
                    sdot[7] = minutes + "min";
                }
                j = 0;
            }

            list.add(sdot);

            System.out.println(g.getCompletedBy().getForename() + " " + g.getCompletedBy().getSurname() + " " + g.getTaskID().getTaskID() + " " + g.getJoblineID().getJobCode().getCode() + " " + localDateFormat.format(g.getStartTime()) + " " + formatter.format(g.getEndTime()));
        }

        Row<PDPage> titleRow = table.createRow(15f);
        Cell<PDPage> cell = titleRow.createCell(100, "Individual Report");
        cell.setFont(PDType1Font.HELVETICA_BOLD);
        cell.setFillColor(Color.WHITE);
        table.addHeaderRow(titleRow);

        Row<PDPage> headerRow = table.createRow(15f);
        Cell<PDPage> cell2 = headerRow.createCell(100 / 8f, "Name");
        cell2.setFont(PDType1Font.HELVETICA_BOLD);
        Cell<PDPage> cell3 = headerRow.createCell(100 / 8f, "Job Code");
        cell3.setFont(PDType1Font.HELVETICA_BOLD);
        Cell<PDPage> cell4 = headerRow.createCell(100 / 8f, "Task IDs");
        cell4.setFont(PDType1Font.HELVETICA_BOLD);
        Cell<PDPage> cell5 = headerRow.createCell(100 / 8f, "Department");
        cell5.setFont(PDType1Font.HELVETICA_BOLD);
        Cell<PDPage> cell6 = headerRow.createCell(100 / 8f, "Date");
        cell6.setFont(PDType1Font.HELVETICA_BOLD);
        Cell<PDPage> cell7 = headerRow.createCell(100 / 8f, "Start Time");
        cell7.setFont(PDType1Font.HELVETICA_BOLD);
        Cell<PDPage> cell8 = headerRow.createCell(100 / 8f, "Time Taken");
        cell8.setFont(PDType1Font.HELVETICA_BOLD);
        Cell<PDPage> cell9 = headerRow.createCell(100 / 8f, "Total");
        cell9.setFont(PDType1Font.HELVETICA_BOLD);
        cell.setFont(PDType1Font.HELVETICA_BOLD);
        cell.setFillColor(Color.WHITE);
        table.addHeaderRow(headerRow);

        for (String[] fact : list) {
            
            if (table.getCurrentPage() != page) {
                doc.addPage(page);
                contentStream.close();
                page = table.getCurrentPage();
                contentStream = new PDPageContentStream(doc, page, AppendMode.APPEND, false);

                contentStream.beginText();
            }
            
            Row<PDPage> row = table.createRow(10f);
            cell = row.createCell((100 / 8f), fact[0]);
            for (int i = 1; i < fact.length; i++) {
                cell = row.createCell((100 / 8f), fact[i]);
            }
        }

        int p = 5 * 8;
        contentStream.close();
        doc.addPage(page);
        table.draw();
        doc.save(day + month + year + "Individualreport.pdf");
        doc.close();

    }
    
    public void createSummaryReport(String date1, String date2) throws IOException, ParseException, PrinterException{
        
        
        
        String day1 = date1.substring(1, 2);
        String month1 = date1.substring(3, 5);
        String year1 = date1.substring(6, 10);
        String newDate1 = year1 + "-" + month1 + "-" + day1;
        String day2 = date2.substring(0, 2);
        String month2 = date2.substring(3, 5);
        String year2 = date2.substring(6, 10);
        String newDate2 = year2 + "-" + month2 + "-" + day2;
        PDPage page = new PDPage(PDRectangle.A4);
        PDDocument doc = new PDDocument();
        PDPageContentStream contentStream = new PDPageContentStream(doc, page);
        float hWidth = page.getMediaBox().getWidth() / 4;
        double a = page.getMediaBox().getWidth() / 2.65;
        float hWidth2 = (float) a;
        PDFont font = PDType1Font.HELVETICA_BOLD;
        PDFont font2 = PDType1Font.HELVETICA;
        String period = "Period: " + date1 + " - " + date2;
        PDStreamUtils.write(contentStream, "Summary Performance Report", font, 20, hWidth, 790, Color.BLACK);
        PDStreamUtils.write(contentStream, period, font2, 15, hWidth2-44, 750, Color.BLACK);
        

      
        
        
        
        
        DataManagerImpl dm = new DataManagerImpl();
        List<TaskLine> line = dm.summaryReports(Date.valueOf(newDate1), Date.valueOf(newDate2));
        String[] sdotd1 = new String[5];
        String[] sdotd2 = new String[5];
        String[] sdotn = new String[5];
        
        
         SimpleDateFormat sdf = new SimpleDateFormat("dd-M-yyyy hh:mm:ss");
         SimpleDateFormat sdf2 = new SimpleDateFormat("hh:mm:ss");
         SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
         SimpleDateFormat dayform = new SimpleDateFormat("dd");
         SimpleDateFormat monthform = new SimpleDateFormat("MM");
         SimpleDateFormat yearform = new SimpleDateFormat("yyyy");
         
              
        
        for(int i = 0; i < line.size(); i++){
           
          
           String comparatorDate = formatter.format(line.get(i).getStartTime());
           TaskLine t = line.get(i);
           java.util.Date ff = t.getStartTime();
           
           
            if(i+1 < line.size()){
               String tempDate = formatter.format(line.get(i+1).getStartTime()); 
           
           
                if(comparatorDate.compareTo(tempDate)==0){
                    
                    if(t.getEndTime() !=null){
                        groupDep(t);
                    
                    }
                    
                    
                    
                   
                }
                
                else{
                    
                    if(i -1 < 0){
                        
                    
                        
                        if(t.getEndTime() != null){
                        groupDep(t);
                    createGroupingList(t, listd1, listd2, listn);
                    }
            
                    
                        
                        
                        
//                       System.out.println(sdot[0] + " :: " + sdot[1] + " :: " + sdot[2] + " :: " + sdot[3] + " :: " + sdot[4]);
//                        sdot =new String[5];
                        
                        
                    }
                    
                    
                    else{
                        
                        
                        if(t.getEndTime()!= null){
                        groupDep(t);
                        createGroupingList(t, listd1, listd2, listn);
                    
                    }
                       
                        

                        
                       
                        
                        
                        
                    }
                    
                    
                    
                }
                
                
                
            }
            
        }
        
        
        
        
        PDStreamUtils.write(contentStream, "Day Shift 1", font, 14, hWidth+65, 720, Color.BLACK);
        PDStreamUtils.write(contentStream, "(5:00am - 2:30pm)", font, 9, hWidth+140, 718, Color.BLACK);
        drawSummaryTable(listd1,page,doc, contentStream);
        
        
       page = new PDPage();
       
       contentStream = new PDPageContentStream(doc, page, AppendMode.APPEND, false);
       
       PDStreamUtils.write(contentStream, "Day Shift 2", font, 14, hWidth+65, 720, Color.BLACK);
        PDStreamUtils.write(contentStream, "(2:30pm - 10:00pm)", font, 9, hWidth+140, 718, Color.BLACK);
       
        
        drawSummaryTable(listd2,page,doc, contentStream);
        
        page = new PDPage();
        contentStream = new PDPageContentStream(doc, page, AppendMode.APPEND, false);
        
        PDStreamUtils.write(contentStream, "Night Shift 1", font, 14, hWidth+65, 720, Color.BLACK);
        PDStreamUtils.write(contentStream, "( 10:00pm- 5:00am)", font, 9, hWidth+160, 718, Color.BLACK);
        
        drawSummaryTable(listn,page,doc, contentStream);
        
        contentStream = new PDPageContentStream(doc, page, AppendMode.APPEND, false);
        
        
        drawSummaryReportTotal(page, doc, contentStream, date1 , date2);

        
        
        contentStream.close();
       
       
        doc.save( "Summaryreport.pdf");
        DocPrinter dp = new DocPrinter();
        dp.printFile(doc);
        doc.close();
       
        
        
        
    }
    
    public void groupDep(TaskLine t) throws ParseException{
          
        
        SimpleDateFormat sdf = new SimpleDateFormat("dd-M-yyyy hh:mm:ss");
         SimpleDateFormat sdf2 = new SimpleDateFormat("hh:mm:ss");
         SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
         SimpleDateFormat dayform = new SimpleDateFormat("dd");
         SimpleDateFormat monthform = new SimpleDateFormat("MM");
         SimpleDateFormat yearform = new SimpleDateFormat("yyyy");
        
        if(t.getTaskID().getDepartment().compareTo("Copy Room")==0){
                        long duration = t.getEndTime().getTime() - t.getStartTime().getTime();
                        
                        String day3 = dayform.format(t.getStartTime());
                        String month3 = monthform.format(t.getStartTime());
                        String year3 = yearform.format(t.getStartTime());
                        java.util.Date ds1 =  sdf.parse(day3 + "-" + month3 + "-" +  year3+  " 5:00:00");
                        long ds1Mill = ds1.getTime();
                        java.util.Date ds2 =  sdf.parse(day3 + "-" + month3 + "-" + year3 +  " 14:30:00");
                        long ds2Mill = ds2.getTime();
                        java.util.Date ns = sdf.parse(day3 + "-" + month3 + "-" + year3 +  " 22:00:00");
                        long nsMill = ns.getTime();
                        
                        Calendar c = Calendar.getInstance();
                        c.setTime(ds1);
                        
                        
                        c.add(Calendar.DAY_OF_MONTH, 1);
                        
                        
                        java.util.Date ns2 = c.getTime();
                        
                        
                        if(t.getStartTime().after(ds1) && t.getStartTime().before(ds2)){
                            
                            if(t.getEndTime().before(ds2)){
                                copyd1+= duration;
                                copyd1Total+= duration;
                                copyTotal += duration;
                            }
                            
                            else if(t.getEndTime().after(ds2) && t.getEndTime().before(ns)){
                                long shift1 = ds2.getTime() -t.getStartTime().getTime();
                                copyd1 += shift1;
                                copyd1Total+= shift1 ;
                                copyTotal+= shift1 ;
                                copyd2+= (t.getEndTime().getTime() - ds2.getTime());
                                copyd2Total += (t.getEndTime().getTime() - ds2.getTime());
                                copyTotal+= (t.getEndTime().getTime() - ds2.getTime());
                            }
                            
                            else if(t.getEndTime().after(ns) && t.getEndTime().before(ns2)){
                                long shift1 = ds2.getTime() - t.getStartTime().getTime();
                                long shift2 = ns.getTime() - ds2.getTime() ;
                                copyd1 += duration -shift1;
                                copyd1Total += duration - shift1;
                                copyTotal += duration - shift1;
                                copyd2+= ns.getTime() - ds2.getTime();
                                copyd2Total += ns.getTime() - ds2.getTime();
                                copyTotal += ns.getTime()-ds2.getTime();
                                copyn += (t.getEndTime().getTime() - ns.getTime());
                                copynTotal += (t.getEndTime().getTime() - ns.getTime());
                                copyTotal += (t.getEndTime().getTime()- ns.getTime());
                            }
                            
                        }
                        
                        if(t.getStartTime().after(ds2) && t.getStartTime().before(ns)){
                            
                            if(t.getEndTime().before(ns)){
                                copyd2+= duration; 
                                copyd2Total+= duration;
                                copyTotal += duration;
                            }
                            
                            else if(t.getEndTime().after(ns) && t.getEndTime().before(ns2)){
                              
                                long shift1 = ns.getTime() -t.getStartTime().getTime();
                                copyd2 += shift1 ;
                                copyd2Total += shift1;
                                copyTotal += shift1; 
                                copyn+= (t.getEndTime().getTime() - ns.getTime());
                                copynTotal += (t.getEndTime().getTime() - ns.getTime());
                                copyTotal += (t.getEndTime().getTime() - ns.getTime());
                            }
                           
                        }
                        
                        
                        if(t.getStartTime().after(ns) && t.getStartTime().before(ns2)){
                            
                            
                           copyn+= duration; 
                           copynTotal+= duration;
                           copyTotal += duration;
                        }
                        
                    }
                    
                    if(t.getTaskID().getDepartment().compareTo("Development Area")==0){
                        long duration = t.getEndTime().getTime() - t.getStartTime().getTime();
                         String day3 = dayform.format(t.getStartTime());
                        String month3 = monthform.format(t.getStartTime());
                        String year3 = yearform.format(t.getStartTime());
                        java.util.Date ds1 =  sdf.parse(day3 + "-" + month3 + "-" + year3 +  " 5:00:00");
                        java.util.Date ds2 =  sdf.parse(day3 + "-" + month3 + "-" + year3 +  " 14:30:00");
                        java.util.Date ns =  sdf.parse(day3 + "-" + month3 + "-" + year3 +  " 22:00:00");
                        
                       
                        
                        Calendar c = Calendar.getInstance();
                        c.setTime(ds1);
                        
                        
                        c.add(Calendar.DAY_OF_MONTH, 1);
                        
                        
                        java.util.Date ns2 =  c.getTime();
                        
                        
                          if(t.getStartTime().after(ds1) && t.getStartTime().before(ds2)){
                            
                            if(t.getEndTime().before(ds2)){
                                developmentd1+= duration;
                                developmentd1Total += duration;
                                developmentTotal += duration;
                            }
                            
                            else if(t.getEndTime().after(ds2) && t.getEndTime().before(ns)){
                                long shift1 = ds2.getTime() -t.getStartTime().getTime();
                                developmentd1 += shift1;
                                developmentd1Total += shift1;
                                developmentTotal += shift1;
                                developmentTotal += shift1;
                                developmentd2+= (t.getEndTime().getTime() - ds2.getTime());
                                developmentd2Total += (t.getEndTime().getTime() - ds2.getTime());
                                developmentTotal += (t.getEndTime().getTime() - ds2.getTime());
                                
                            }
                            
                            else if(t.getEndTime().after(ns) && t.getEndTime().before(ns2)){
                                long shift1 = ds2.getTime() - t.getStartTime().getTime();
                                long shift2 = ns.getTime() - ds2.getTime();
                                developmentd1 += shift1;
                                developmentd1Total+= shift1;
                                developmentTotal += shift1;
                                developmentd2+= ns.getTime() - ds2.getTime();
                                developmentd2Total+= ns.getTime() - ds2.getTime();
                                developmentTotal = ns.getTime() - ds2.getTime();
                                developmentn +=  (t.getEndTime().getTime() - ns.getTime());
                                developmentnTotal += (t.getEndTime().getTime() - ns.getTime());
                                developmentTotal+= (t.getEndTime().getTime() - ns.getTime());
                            }
                            
                        }
                        
                        if(t.getStartTime().after(ds2) && t.getStartTime().before(ns)){
                            
                            if(t.getEndTime().before(ns)){
                                developmentd2+= duration; 
                                developmentd2Total += duration;
                                developmentTotal += duration;
                            }
                            
                            else if(t.getEndTime().after(ns)){
                              
                                long shift1 = ns.getTime() -t.getStartTime().getTime();
                                developmentd2 += shift1;
                                developmentd2Total+= shift1;
                                developmentTotal+= shift1;
                                developmentn+= (t.getEndTime().getTime() - ns.getTime());
                                developmentnTotal += (t.getEndTime().getTime() - ns.getTime());
                                developmentTotal += (t.getEndTime().getTime() - ns.getTime());
                                
                            }
                           
                        }
                        
                        
                        if(t.getStartTime().after(ns) && t.getStartTime().before(ns2)){
                            
                            
                           developmentn+= duration; 
                           developmentnTotal += duration;
                           developmentTotal += duration;
                        }
                        
                        
                    }
                    
                    if(t.getTaskID().getDepartment().compareTo("Packing Departments")==0){
                             long duration = t.getEndTime().getTime() - t.getStartTime().getTime();
                         String day3 = dayform.format(t.getStartTime());
                        String month3 = monthform.format(t.getStartTime());
                        String year3 = yearform.format(t.getStartTime());
                        java.util.Date ds1 = sdf.parse(day3 + "-" + month3 + "-" + year3 +  " 5:00:00");
                        java.util.Date ds2 = sdf.parse(day3 + "-" + month3 + "-" + year3 +  " 14:30:00");
                        java.util.Date ns = sdf.parse(day3 + "-" + month3 + "-" + year3 +  " 22:00:00");
                        
                       
                        
                        Calendar c = Calendar.getInstance();
                        c.setTime(ds1);
                        
                        
                        c.add(Calendar.DAY_OF_MONTH, 1);
                        
                        
                        java.util.Date ns2 =  c.getTime();
                        
                        
                        if(t.getStartTime().after(ds1) && t.getStartTime().before(ds2)){
                            
                            if(t.getEndTime().before(ds2)){
                                packingd1+= duration;
                                packingd1Total += duration;
                                packingTotal += duration;
                            }
                            
                            else if(t.getEndTime().after(ds2) && t.getEndTime().before(ns)){
                                long shift1 = ds2.getTime() -t.getStartTime().getTime();
                                packingd1 += shift1;
                                packingd1Total += shift1;
                                packingTotal += shift1;
                                packingd2+= (t.getEndTime().getTime() - ds2.getTime());
                                packingd2Total += (t.getEndTime().getTime() - ds2.getTime());
                                packingTotal += (t.getEndTime().getTime() - ds2.getTime());
                            }
                            
                            else if(t.getEndTime().after(ns) && t.getEndTime().before(ns2)){
                                long shift1 = ds2.getTime() - t.getStartTime().getTime();
                                long shift2 = ns.getTime() - ds2.getTime();
                                packingd1 += shift1;
                                packingd1Total += shift1;
                                packingTotal += shift1;
                                packingd2+= ns.getTime() - ds2.getTime();
                                packingd2Total += ns.getTime() - ds2.getTime();
                                packingTotal+= ns.getTime() - ds2.getTime();
                                packingn += (t.getEndTime().getTime() - ns.getTime());
                                packingnTotal+= (t.getEndTime().getTime() - ns.getTime());
                                packingTotal += (t.getEndTime().getTime() - ns.getTime());
                            }
                            
                        }
                        
                        if(t.getStartTime().after(ds2) && t.getStartTime().before(ns)){
                            
                            if(t.getEndTime().before(ns)){
                                packingd2+= duration; 
                                packingd2Total+= duration;
                                packingTotal += duration;
                            }
                            
                            else if(t.getEndTime().after(ns)){
                              
                                long shift1 = ns.getTime() -t.getStartTime().getTime();
                                packingd2 += shift1;
                                packingd2Total += shift1;
                                packingTotal += shift1;
                                packingn+= (t.getEndTime().getTime() - ns.getTime());
                                packingnTotal += (t.getEndTime().getTime() - ns.getTime());
                                packingTotal += (t.getEndTime().getTime()-ns.getTime());
                            }
                           
                        }
                        
                        
                        if(t.getStartTime().after(ns) && t.getStartTime().before(ns2)){
                            
                            
                           packingn+= duration; 
                           packingnTotal += duration;
                           packingTotal+= duration;
                        }
                        
                    }
                    
                    if(t.getTaskID().getDepartment().compareTo("Finishing Room")==0){
                             long duration = t.getEndTime().getTime() - t.getStartTime().getTime();
                         String day3 = dayform.format(t.getStartTime());
                        String month3 = monthform.format(t.getStartTime());
                        String year3 = yearform.format(t.getStartTime());
                        java.util.Date ds1 =  sdf.parse(day3 + "-" + month3 + "-" + year3 +  " 5:00:00");
                        java.util.Date ds2 =  sdf.parse(day3 + "-" + month3 + "-" + year3 +  " 14:30:00");
                        java.util.Date ns =  sdf.parse(day3 + "-" + month3 + "-" + year3 +  " 22:00:00");
                        
                       
                        
                        Calendar c = Calendar.getInstance();
                        c.setTime(ds1);
                        
                        
                        c.add(Calendar.DAY_OF_MONTH, 1);
                        
                        
                        java.util.Date ns2 =  c.getTime();
                        
                        
                        if(t.getStartTime().after(ds1) && t.getStartTime().before(ds2)){
                            
                            if(t.getEndTime().before(ds2)){
                                finishingd1+= duration;
                                finishingd1Total += duration;
                                finishingTotal += duration;
                            }
                            
                            else if(t.getEndTime().after(ds2) && t.getEndTime().before(ns)){
                                long shift1 = ds2.getTime() -t.getStartTime().getTime();
                                finishingd1 += shift1;
                                finishingd1Total += shift1;
                                finishingTotal += shift1;
                                finishingd2+= (t.getEndTime().getTime() - ds2.getTime());
                                finishingd2Total += (t.getEndTime().getTime()-ds2.getTime());
                                finishingTotal += (t.getEndTime().getTime() - ds2.getTime());
                            }
                            
                            else if(t.getEndTime().after(ns) && t.getEndTime().before(ns2)){
                                long shift1 = ds2.getTime() - t.getStartTime().getTime();
                                long shift2 = ns.getTime() - ds2.getTime();
                                finishingd1 += shift1;
                                finishingd1Total += shift1;
                                finishingTotal += shift1;
                                finishingd2+= ns.getTime() - ds2.getTime();
                                finishingd2Total += ns.getTime()-ds2.getTime();
                                finishingTotal += ns.getTime()- ds2.getTime();
                                finishingn += (t.getEndTime().getTime() - ns.getTime());
                                finishingnTotal += (t.getEndTime().getTime()- ns.getTime());
                                finishingTotal += ( t.getEndTime().getTime() - ns.getTime());
                                
                            }
                            
                        }
                        
                        if(t.getStartTime().after(ds2) && t.getStartTime().before(ns)){
                            
                            if(t.getEndTime().before(ns)){
                                finishingd2+= duration; 
                                finishingd2Total += duration;
                                finishingTotal += duration;
                            }
                            
                            else if(t.getEndTime().after(ns)){
                              
                                long shift1 = ns.getTime() -t.getStartTime().getTime();
                                finishingd2 += shift1;
                                finishingd2Total += shift1;
                                finishingTotal += shift1;
                                finishingn+= (t.getEndTime().getTime() - ns.getTime());
                                finishingnTotal += (t.getEndTime().getTime()-ns.getTime());
                                finishingTotal+= (t.getEndTime().getTime() - ns.getTime());
                            }
                           
                        }
                        
                        
                        if(t.getStartTime().after(ns) && t.getStartTime().before(ns2)){
                            
                            
                           finishingn+= duration; 
                           finishingnTotal += duration;
                           finishingTotal+= duration;
                        }
                    }
                    
                    
                    
                   
                
        
    }
    
    
    
    
    public void createGroupingList(TaskLine t, List<String[]> listd1, List<String[]> listd2, List<String[]> listn) throws ParseException{
        
        
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        String[] sdotd1 = new String[5];
        String[] sdotd2 = new String[5];
        String[] sdotn = new String[5];
        
                        sdotd1[0] = formatter.format(t.getStartTime());
                        sdotd1[1] = String.valueOf((int) ((copyd1 / (1000 * 60 * 60)))) + " hrs " + (int) ((copyd1 / (1000 * 60)) % 60) + " mins";
                        sdotd1[2] = String.valueOf((int) ((developmentd1 / (1000 * 60 * 60)))) + " hrs " + (int) ((developmentd1 / (1000 * 60)) % 60) + " mins";
                        sdotd1[3] = String.valueOf((int) ((packingd1 / (1000 * 60 * 60)))) + " hrs " + (int) ((packingd1 / (1000 * 60)) % 60) + " mins";
                        sdotd1[4] = String.valueOf((int) ((finishingd1 / (1000 * 60 * 60)))) + " hrs " + (int) ((finishingd1 / (1000 * 60)) % 60) + " mins";
                    
                        listd1.add(sdotd1);
                        sdotd1 =new String[5];
                        
                        
                        copyd1 = 0;
                        developmentd1 = 0; 
                        packingd1 = 0;
                        finishingd1 = 0;
                        
                        
                        sdotd2[0] = formatter.format(t.getStartTime());
                        sdotd2[1] = String.valueOf((int) ((copyd2 / (1000 * 60 * 60)))) + " hrs " + (int) ((copyd2 / (1000 * 60)) % 60) + " mins";
                        sdotd2[2] = String.valueOf((int) ((developmentd2 / (1000 * 60 * 60)))) + " hrs " + (int) ((developmentd2 / (1000 * 60)) % 60) + " mins";
                        sdotd2[3] = String.valueOf((int) ((packingd2 / (1000 * 60 * 60)))) + " hrs " + (int) ((packingd2 / (1000 * 60)) % 60) + " mins";
                        sdotd2[4] = String.valueOf((int) ((finishingd2 / (1000 * 60 * 60)))) + " hrs " + (int) ((finishingd2 / (1000 * 60)) % 60) + " mins";
                        
                        listd2.add(sdotd2);
                        sdotd2 =new String[5];
                        
                        copyd2 = 0;
                        developmentd2 = 0; 
                        packingd2 = 0;
                        finishingd2 = 0;
                        
                        sdotn[0] = formatter.format(t.getStartTime());
                        sdotn[1] = String.valueOf((int) ((copyn / (1000 * 60 * 60)))) + " hrs " + (int) ((copyn / (1000 * 60)) % 60) + " mins";
                        sdotn[2] = String.valueOf((int) ((developmentn / (1000 * 60 * 60)))) + " hrs " + (int) ((developmentn / (1000 * 60)) % 60) + " mins";
                        sdotn[3] = String.valueOf((int) ((packingn / (1000 * 60 * 60)))) + " hrs " + (int) ((packingn / (1000 * 60)) % 60) + " mins";
                        sdotn[4] = String.valueOf((int) ((finishingn / (1000 * 60 * 60)))) + " hrs " + (int) ((finishingn / (1000 * 60)) % 60) + " mins";
                    
                        listn.add(sdotn);
                        sdotn =new String[5];
                        
                        copyn = 0;
                        developmentn = 0; 
                        packingn = 0;
                        finishingn = 0;
        
    }
    
    
    
    public void drawSummaryTable(List<String[]> list, PDPage page, PDDocument doc,PDPageContentStream contentStream) throws IOException, PrinterException{
        float margin = 50;
        float yStartNewPage = page.getMediaBox().getHeight() - (2 * margin) -150;
        float tableWidth = page.getMediaBox().getWidth() - (2 * margin);

        float bottomMargin = 70;
        float yPosition = 700;
        
           BaseTable table = new BaseTable(yPosition, yStartNewPage, bottomMargin, tableWidth, margin, doc, page, true, true);
         Row<PDPage> titleRow = table.createRow(15f);
        Cell<PDPage> cell = titleRow.createCell(100, "Summary Report");
        cell.setFont(PDType1Font.HELVETICA_BOLD);
        cell.setFillColor(Color.WHITE);
        table.addHeaderRow(titleRow);

        Row<PDPage> headerRow = table.createRow(15f);
        Cell<PDPage> cell2 = headerRow.createCell(100 / 5f, "Date");
        cell2.setFont(PDType1Font.HELVETICA_BOLD);
        Cell<PDPage> cell3 = headerRow.createCell(100 / 5f, "Copy Room");
        cell3.setFont(PDType1Font.HELVETICA_BOLD);
        Cell<PDPage> cell4 = headerRow.createCell(100 / 5f, "Development Area");
        cell4.setFont(PDType1Font.HELVETICA_BOLD);
        Cell<PDPage> cell5 = headerRow.createCell(100 / 5f, "Packing Department");
        cell5.setFont(PDType1Font.HELVETICA_BOLD);
        Cell<PDPage> cell6 = headerRow.createCell(100 / 5f, "Finishing Room");
        cell6.setFont(PDType1Font.HELVETICA_BOLD);
    
        cell.setFont(PDType1Font.HELVETICA_BOLD);
        cell.setFillColor(Color.WHITE);
        table.addHeaderRow(headerRow);

        for (String[] fact : list) {
            
             if (table.getCurrentPage() != page) {
                doc.addPage(page);
                contentStream.close();
                page = table.getCurrentPage();
                contentStream = new PDPageContentStream(doc, page, AppendMode.APPEND, false);

                contentStream.beginText();
            }
            Row<PDPage> row = table.createRow(10f);
            cell = row.createCell((100 / 5f), fact[0]);
            for (int i = 1; i < fact.length; i++) {
                cell = row.createCell((100 / 5f), fact[i]);
            }
        }
       
        

        doc.addPage(page);
        table.draw();
        contentStream.close();
        
       
        
    }
    
    
    public void drawSummaryReportTotal(PDPage page, PDDocument doc,PDPageContentStream contentStream, String date1, String date2) throws IOException{
        page = new PDPage();
        List<String[]> list = new LinkedList();
        String [] colNames = new String[5];
        colNames[0] = " ";
        colNames [1] = "Copy Room";
        colNames [2] = "Development";
        colNames [3] = "Packing";
        colNames [4] = "Finishing";
         list.add(colNames);
         String [] d1Row = new String[5];
         d1Row[0] = "Day Shift 1";
         d1Row[1] = String.valueOf((int) ((copyd1Total / (1000 * 60 * 60)))) + " hrs " + (int) ((copyd1Total / (1000 * 60)) % 60) + " mins";
         d1Row[2] = String.valueOf((int) ((developmentd1Total / (1000 * 60 * 60)))) + " hrs " + (int) ((developmentd1Total / (1000 * 60)) % 60) + " mins";
         d1Row[3] = String.valueOf((int) ((packingd1Total / (1000 * 60 * 60)))) + " hrs " + (int) ((packingd1Total / (1000 * 60)) % 60) + " mins";
         d1Row[4] = String.valueOf((int) ((finishingd1Total / (1000 * 60 * 60)))) + " hrs " + (int) ((finishingd1Total / (1000 * 60)) % 60) + " mins";
         list.add(d1Row);
         
         
         String [] d2Row = new String[5];
         d2Row[0] = "Day Shift 2";
         d2Row[1] = String.valueOf((int) ((copyd2Total / (1000 * 60 * 60)))) + " hrs " + (int) ((copyd2Total / (1000 * 60)) % 60) + " mins";
         d2Row[2] = String.valueOf((int) ((developmentd2Total / (1000 * 60 * 60)))) + " hrs " + (int) ((developmentd2Total / (1000 * 60)) % 60) + " mins";
         d2Row[3] = String.valueOf((int) ((packingd2Total / (1000 * 60 * 60)))) + " hrs " + (int) ((packingd2Total / (1000 * 60)) % 60) + " mins";
         d2Row[4] = String.valueOf((int) ((finishingd2Total / (1000 * 60 * 60)))) + " hrs " + (int) ((finishingd2Total / (1000 * 60)) % 60) + " mins";
         list.add(d2Row);
         
         
         
         String [] nRow = new String[5];
         nRow[0] = "Night Shift";
         nRow[1] = String.valueOf((int) ((copynTotal / (1000 * 60 * 60)))) + " hrs " + (int) ((copynTotal / (1000 * 60)) % 60) + " mins";
         nRow[2] = String.valueOf((int) ((developmentnTotal / (1000 * 60 * 60)))) + " hrs " + (int) ((developmentnTotal / (1000 * 60)) % 60) + " mins";
         nRow[3] = String.valueOf((int) ((packingnTotal / (1000 * 60 * 60)))) + " hrs " + (int) ((packingnTotal / (1000 * 60)) % 60) + " mins";
         nRow[4] = String.valueOf((int) ((finishingnTotal / (1000 * 60 * 60)))) + " hrs " + (int) ((finishingnTotal / (1000 * 60)) % 60) + " mins";
         list.add(nRow);
         
         
         
         
         String [] totalRow = new String[5];
         totalRow[0] = "Total";
         totalRow[1] = String.valueOf((int) ((copyTotal / (1000 * 60 * 60)))) + " hrs " + (int) ((copyTotal / (1000 * 60)) % 60) + " mins";
         totalRow[2] = String.valueOf((int) ((developmentTotal / (1000 * 60 * 60)))) + " hrs " + (int) ((developmentTotal / (1000 * 60)) % 60) + " mins";
         totalRow[3] = String.valueOf((int) ((packingTotal / (1000 * 60 * 60)))) + " hrs " + (int) ((packingTotal / (1000 * 60)) % 60) + " mins";
         totalRow[4] = String.valueOf((int) ((finishingTotal / (1000 * 60 * 60)))) + " hrs " + (int) ((finishingTotal / (1000 * 60)) % 60) + " mins";
         list.add(totalRow);
         
         
        float margin = 50;
        float yStartNewPage = page.getMediaBox().getHeight() - (2 * margin) -150;
        float tableWidth = page.getMediaBox().getWidth() - (2 * margin);

        float bottomMargin = 70;
        float yPosition = 700;
        
        BaseTable table = new BaseTable(yPosition, yStartNewPage, bottomMargin, tableWidth, margin, doc, page, true, true);
        Row<PDPage> titleRow = table.createRow(15f);
        Cell<PDPage> cell = titleRow.createCell(100, "Total for Period (" + date1 + " - " + date2 + ")");
        cell.setFont(PDType1Font.HELVETICA_BOLD);
        
        for (String[] fact : list) {
            
             if (table.getCurrentPage() != page) {
                doc.addPage(page);
                contentStream.close();
                page = table.getCurrentPage();
                contentStream = new PDPageContentStream(doc, page, AppendMode.APPEND, false);

                contentStream.beginText();
            }
            Row<PDPage> row = table.createRow(10f);
            cell = row.createCell((100 / 5f), fact[0]);
            for (int i = 1; i < fact.length; i++) {
                cell = row.createCell((100 / 5f), fact[i]);
            }
        }
         
         doc.addPage(page);
        table.draw();
        contentStream.close();
         
        
    }
    
    public void createCustomerReport(String accNo, String date1, String date2) throws IOException, ParseException, PrinterException{
        
        
        String day1 = date1.substring(1, 2);
        String month1 = date1.substring(3, 5);
        String year1 = date1.substring(6, 10);
        String newDate1 = year1 + "-" + month1 + "-" + day1;
        String day2 = date2.substring(0, 2);
        String month2 = date2.substring(3, 5);
        String year2 = date2.substring(6, 10);
        String newDate2 = year2 + "-" + month2 + "-" + day2;
        String period = "Period: " + date1 + " - " + date2;
        PDPage page = new PDPage(PDRectangle.A4);
        PDDocument doc = new PDDocument();
        PDPageContentStream contentStream = new PDPageContentStream(doc, page);
        float hWidth = page.getMediaBox().getWidth() / 4;
        double a = page.getMediaBox().getWidth() / 2.65;
        float hWidth2 = (float) a;
        PDFont font = PDType1Font.HELVETICA_BOLD;
        PDFont font2 = PDType1Font.HELVETICA;
        DataManagerImpl dm = new DataManagerImpl();
       Customer c = dm.findCustomerByAccountNumber(accNo);
       List<String[]> list = new ArrayList<String[]>();
        
        PDStreamUtils.write(contentStream, "Customer Accounts Report for Account: " + c.getAccountHolderName(), font, 12, hWidth/2, 790, Color.BLACK);
        PDStreamUtils.write(contentStream, period, font2, 10, hWidth2-44, 750, Color.BLACK);
        
        
        
        
        Collection<OrderTable> oList = c.getOrderTableCollection();
        
        for (OrderTable o : oList){
            
            if(o.getDateSubmitted().after(new SimpleDateFormat("dd/MM/yyyy").parse(date1)) && o.getDateSubmitted().before(new SimpleDateFormat("dd/MM/yyyy").parse(date2))){
               
                
                Collection<JobLine> jList = o.getJobLineCollection();
            for(JobLine js : jList){
                
                
                String[] sdot = new String[5];
                sdot[0] = String.valueOf(js.getJoblineID());
                sdot[1] = js.getJobCode().getCode();
                sdot[2] = String.valueOf(js.getOrderID().getOrderID());
                sdot[3] = js.getOrderID().getDateSubmitted().toString();
                if(js.isPaidFor()){
                    
                    sdot[4] = "Paid";
                    
                }
                
                else{
                    sdot[4] = "Unpaid";
                }
                
                list.add(sdot);
                
            }
            
            
                
                
                
               
            }
            
            
                
            
            
            
            
        }
        
       
        
        float margin = 50;
        float yStartNewPage = page.getMediaBox().getHeight() - (2 * margin) -150;
        float tableWidth = page.getMediaBox().getWidth() - (2 * margin);

        float bottomMargin = 70;
        float yPosition = 700;
        
           BaseTable table = new BaseTable(yPosition, yStartNewPage, bottomMargin, tableWidth, margin, doc, page, true, true);
         Row<PDPage> titleRow = table.createRow(15f);
        Cell<PDPage> cell = titleRow.createCell(100, "Account Number: " + c.getAccountNo() + "      Name: " + c.getForename()+ " " + c.getSurname());
        cell.setFont(PDType1Font.HELVETICA_BOLD);
        cell.setFillColor(Color.WHITE);
        table.addHeaderRow(titleRow);

        Row<PDPage> headerRow = table.createRow(15f);
        Cell<PDPage> cell2 = headerRow.createCell(100 / 5f, "Job Id");
        cell2.setFont(PDType1Font.HELVETICA_BOLD);
        Cell<PDPage> cell3 = headerRow.createCell(100 / 5f, "Job Code");
        cell3.setFont(PDType1Font.HELVETICA_BOLD);
        Cell<PDPage> cell4 = headerRow.createCell(100 / 5f, "Order Id");
        cell4.setFont(PDType1Font.HELVETICA_BOLD);
        Cell<PDPage> cell5 = headerRow.createCell(100 / 5f, "Date submitted");
        cell5.setFont(PDType1Font.HELVETICA_BOLD);
        Cell<PDPage> cell6 = headerRow.createCell(100 / 5f, "Payment Status");
        cell6.setFont(PDType1Font.HELVETICA_BOLD);
    
        cell.setFont(PDType1Font.HELVETICA_BOLD);
        cell.setFillColor(Color.WHITE);
        table.addHeaderRow(headerRow);

        for (String[] fact : list) {
            
             if (table.getCurrentPage() != page) {
                doc.addPage(page);
                contentStream.close();
                page = table.getCurrentPage();
                contentStream = new PDPageContentStream(doc, page, AppendMode.APPEND, false);

                

                contentStream.beginText();
            }
            Row<PDPage> row = table.createRow(10f);
            cell = row.createCell((100 / 5f), fact[0]);
            for (int i = 1; i < fact.length; i++) {
                cell = row.createCell((100 / 5f), fact[i]);
            }
        }
       
        contentStream.close();
        doc.addPage(page);
        table.draw();
        
        
       
        doc.save( "customerReport.pdf");
        DocPrinter dp = new DocPrinter();
        dp.printFile(doc);
       
        doc.close();
        
        
        
    }
    
    

}
