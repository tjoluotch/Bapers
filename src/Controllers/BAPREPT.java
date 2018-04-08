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
import domain.JobLine;
import java.awt.Color;
import java.io.IOException;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.PDPageContentStream.AppendMode;
import org.apache.pdfbox.pdmodel.common.PDRectangle;
import org.apache.pdfbox.pdmodel.font.PDFont;
import org.apache.pdfbox.pdmodel.font.PDType1Font;

/**
 *
 * @author Daniel
 */
public class BAPREPT {

    public BAPREPT() {
    }

    public void createIndividualReport(String date1, String date2) throws IOException {
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
        List<JobLine> line = dm.individualReportBetween(Date.valueOf(newDate1), Date.valueOf(newDate2));
        List<String[]> list = new ArrayList<String[]>();
        SimpleDateFormat localDateFormat = new SimpleDateFormat("HH:mm");
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        SimpleDateFormat form = new SimpleDateFormat("HH:mm");
        long j = 0;
        long total = 0;

        for (int i = 0; i < line.size(); i++) {
            JobLine g = line.get(i);

            String[] sdot = new String[8];
            sdot[0] = g.getCompletedBy().getFirstName() + " " + g.getCompletedBy().getSurname();
            sdot[1] = g.getCode().getCode();
            sdot[2] = Integer.toString(g.getTaskID().getTaskID());
            sdot[3] = g.getTaskID().getDepartment();
            sdot[4] = formatter.format(g.getDate());
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

            System.out.println(g.getCompletedBy().getFirstName() + " " + g.getCompletedBy().getSurname() + " " + g.getTaskID().getTaskID() + " " + g.getCode().getCode() + " " + localDateFormat.format(g.getStartTime()) + " " + formatter.format(g.getDate()));
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
        doc.close();
    }

    public void createYearlyReport(String date1, String date2) throws IOException {
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
        List<JobLine> line = dm.individualReportBetween(Date.valueOf(newDate1), Date.valueOf(newDate2));
        List<String[]> list = new ArrayList<String[]>();
        SimpleDateFormat localDateFormat = new SimpleDateFormat("HH:mm");
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        SimpleDateFormat form = new SimpleDateFormat("HH:mm");
        long j = 0;
        long total = 0;

        for (int i = 0; i < line.size(); i++) {
            JobLine g = line.get(i);

            String[] sdot = new String[8];
            sdot[0] = g.getCompletedBy().getFirstName() + " " + g.getCompletedBy().getSurname();
            sdot[1] = g.getCode().getCode();
            sdot[2] = Integer.toString(g.getTaskID().getTaskID());
            sdot[3] = g.getTaskID().getDepartment();
            sdot[4] = formatter.format(g.getDate());
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

            System.out.println(g.getCompletedBy().getFirstName() + " " + g.getCompletedBy().getSurname() + " " + g.getTaskID().getTaskID() + " " + g.getCode().getCode() + " " + localDateFormat.format(g.getStartTime()) + " " + formatter.format(g.getDate()));
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
        cell11.setFont(PDType1Font.HELVETICA_BOLD);

        int p = 5 * 8;
        table.draw();
        contentStream.close();
        doc.addPage(page);
        doc.save(year1 + "_" + "Individualreport.pdf");
        doc.close();
    }

    public void createQuarterlyReport(String date1, String date2, String quarter, String q) throws IOException {
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
        List<JobLine> line = dm.individualReportBetween(Date.valueOf(newDate1), Date.valueOf(newDate2));
        List<String[]> list = new ArrayList<String[]>();
        SimpleDateFormat localDateFormat = new SimpleDateFormat("HH:mm");
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        SimpleDateFormat form = new SimpleDateFormat("HH:mm");
        long j = 0;
        long total = 0;

        for (int i = 0; i < line.size(); i++) {
            JobLine g = line.get(i);

            String[] sdot = new String[8];
            sdot[0] = g.getCompletedBy().getFirstName() + " " + g.getCompletedBy().getSurname();
            sdot[1] = g.getCode().getCode();
            sdot[2] = Integer.toString(g.getTaskID().getTaskID());
            sdot[3] = g.getTaskID().getDepartment();
            sdot[4] = formatter.format(g.getDate());
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

            System.out.println(g.getCompletedBy().getFirstName() + " " + g.getCompletedBy().getSurname() + " " + g.getTaskID().getTaskID() + " " + g.getCode().getCode() + " " + localDateFormat.format(g.getStartTime()) + " " + formatter.format(g.getDate()));
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
        table.draw();
        contentStream.close();
        doc.addPage(page);
        doc.save(year1 + "_" + quarter + "_Individual_report.pdf");
        doc.close();
    }

    public void createMonthlyReport(String date1, String date2) throws IOException {
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
        PDStreamUtils.write(contentStream, period, font2, 15, hWidth2, 750, Color.BLACK);

        float margin = 50;
        float yStartNewPage = page.getMediaBox().getHeight() - (2 * margin);
        float tableWidth = page.getMediaBox().getWidth() - (2 * margin);

        float bottomMargin = 70;
        float yPosition = 700;
        BaseTable table = new BaseTable(yPosition, yStartNewPage, bottomMargin, tableWidth, margin, doc, page, true, true);
//Create Header row
        DataManagerImpl dm = new DataManagerImpl();
        List<JobLine> line = dm.individualReportBetween(Date.valueOf(newDate1), Date.valueOf(newDate2));
        List<String[]> list = new ArrayList<String[]>();
        SimpleDateFormat localDateFormat = new SimpleDateFormat("HH:mm");
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        SimpleDateFormat form = new SimpleDateFormat("HH:mm");

        long j = 0;
        long total = 0;

        for (int i = 0; i < line.size(); i++) {
            JobLine g = line.get(i);

            String[] sdot = new String[8];
            sdot[0] = g.getCompletedBy().getFirstName() + " " + g.getCompletedBy().getSurname();
            sdot[1] = g.getCode().getCode();
            sdot[2] = Integer.toString(g.getTaskID().getTaskID());
            sdot[3] = g.getTaskID().getDepartment();
            sdot[4] = formatter.format(g.getDate());
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

            System.out.println(g.getCompletedBy().getFirstName() + " " + g.getCompletedBy().getSurname() + " " + g.getTaskID().getTaskID() + " " + g.getCode().getCode() + " " + localDateFormat.format(g.getStartTime()) + " " + formatter.format(g.getDate()));
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
        cell11.setFont(PDType1Font.HELVETICA_BOLD);
        int p = 5 * 8;
        table.draw();
        contentStream.close();
        doc.addPage(page);
        doc.save(monthName + "_" + "Individualreport.pdf");
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
        List<JobLine> line = dm.individualReport(Date.valueOf(newDate));
        List<String[]> list = new ArrayList<String[]>();
        SimpleDateFormat localDateFormat = new SimpleDateFormat("HH:mm");
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        SimpleDateFormat form = new SimpleDateFormat("HH:mm");
        long j = 0;

        for (int i = 0; i < line.size(); i++) {
            JobLine g = line.get(i);

            String[] sdot = new String[8];
            sdot[0] = g.getCompletedBy().getFirstName() + " " + g.getCompletedBy().getSurname();
            sdot[1] = g.getCode().getCode();
            sdot[2] = Integer.toString(g.getTaskID().getTaskID());
            sdot[3] = g.getTaskID().getDepartment();
            sdot[4] = formatter.format(g.getDate());
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

            System.out.println(g.getCompletedBy().getFirstName() + " " + g.getCompletedBy().getSurname() + " " + g.getTaskID().getTaskID() + " " + g.getCode().getCode() + " " + localDateFormat.format(g.getStartTime()) + " " + formatter.format(g.getDate()));
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

        int p = 5 * 8;
        table.draw();
        contentStream.close();
        doc.addPage(page);
        doc.save(day + month + year + "Individualreport.pdf");
        doc.close();

    }

}
