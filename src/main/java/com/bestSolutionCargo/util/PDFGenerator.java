package com.bestSolutionCargo.util;


import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.List;
import java.util.stream.Stream;

import com.itextpdf.text.*;
import com.bestSolutionCargo.models.Orders;
import com.bestSolutionCargo.models.Packing;
import com.bestSolutionCargo.models.SpareParts;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

public class PDFGenerator {

    private static Logger logger = LoggerFactory.getLogger(PDFGenerator.class);

    public static ByteArrayInputStream sparePartsPDFReport(List<SpareParts> sparePartsList)  throws DocumentException, MalformedURLException, IOException {
        Document document = new Document();
        Rectangle rect = new Rectangle(10, 10, 800, 800);
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        PdfWriter writer = PdfWriter.getInstance(document, out);
        writer.setBoxSize("art", rect);
        document.setPageSize(rect);
        HeaderFooterPageEvent event = new HeaderFooterPageEvent();
        writer.setPageEvent(event);
        if (!document.isOpen()) {

            writer.setPageEvent(event);
            document.open();
        }
        try {

            PdfWriter.getInstance(document, out);
             writer.setPageEvent(event);
            document.open();

//            document.newPage();


            Image img = Image.getInstance("src/main/resources/static/logo.png");
            img.scaleAbsolute(60f, 60f);
            img.setAlignment(Element.ALIGN_CENTER);

            Font font = FontFactory.getFont(FontFactory.COURIER, 14, BaseColor.BLACK);
            Font font0 = new Font(Font.FontFamily.TIMES_ROMAN, 14, Font.UNDERLINE);
            Font font1 = new Font(Font.FontFamily.TIMES_ROMAN, 9, Font.BOLD);
            Font font2 = new Font(Font.FontFamily.TIMES_ROMAN, 12, Font.BOLD);
            Font font5 = new Font(Font.FontFamily.TIMES_ROMAN, 12);
            Font font6 = new Font(Font.FontFamily.TIMES_ROMAN, 11, Font.ITALIC);
            Font font7 = new Font(Font.FontFamily.TIMES_ROMAN, 11);
            Font font8 = new Font(Font.FontFamily.TIMES_ROMAN, 12, Font.UNDERLINE);

            Paragraph restricted = new Paragraph( "RESTRICTED");
            restricted.setAlignment(Element.ALIGN_CENTER);
            document.add(restricted);

            Paragraph sp = new Paragraph( "\n");
            document.add(sp);

            PdfPTable table00 = new PdfPTable(30);
            table00.setWidthPercentage(85);
            PdfPCell h1 = new PdfPCell(new Phrase("Tel: +250790134073\n\nEmail: 7assigncomd@minadef.gov", font2));
            h1.setHorizontalAlignment(Element.ALIGN_LEFT);
            h1.setColspan(13);
            h1.setBorder(0);
            table00.addCell(h1);
            PdfPCell h2 = new PdfPCell(img);
            h2.setHorizontalAlignment(Element.ALIGN_CENTER);
            h2.setColspan(4);
            h2.setBorder(0);
            table00.addCell(h2);
            PdfPCell h3 = new PdfPCell(new Phrase("RWANDA AIR FORCE\n7 AIR DEFENCE COMMAND\nKIGALI - RWANDA\n\n\n....MAY 2022", font2));
            h3.setHorizontalAlignment(Element.ALIGN_LEFT);
            h3.setColspan(13);
            h3.setPaddingLeft(6);
            h3.setBorder(0);
            h3.setLeading(15,0);
            table00.addCell(h3);
            document.add(table00);

            // Add Text to PDF file ->
            Paragraph space3x = new Paragraph( "\n\n\n");
            Paragraph space2x = new Paragraph( "\n");
            Paragraph para = new Paragraph( "GOODS RECEIVED ADVICE NOTE", font2);
            para.setAlignment(Element.ALIGN_CENTER);
//            document.add(img);
            document.add(space3x);
            document.add(para);
            document.add(space2x);
//            document.add(Chunk.NEWLINE);


            PdfPTable table01 = new PdfPTable(30);
            table01.setWidthPercentage(100);


            PdfPCell cell01 = new PdfPCell(new Phrase("RECEIVED FROM", font2));
            cell01.setPaddingLeft(6);
            cell01.setPaddingTop(2);
            cell01.setPaddingBottom(2);
            cell01.setColspan(15);
            cell01.setVerticalAlignment(Element.ALIGN_MIDDLE);
            cell01.setHorizontalAlignment(Element.ALIGN_LEFT);
            table01.addCell(cell01);

            PdfPCell cell02 = new PdfPCell(new Phrase("INDRA", font7));
            cell02.setPaddingLeft(6);
            cell02.setPaddingTop(2);
            cell02.setPaddingBottom(2);
            cell02.setColspan(15);
            cell02.setVerticalAlignment(Element.ALIGN_MIDDLE);
            cell02.setHorizontalAlignment(Element.ALIGN_LEFT);
            table01.addCell(cell02);

            PdfPCell cell001 = new PdfPCell(new Phrase("DESTINATION", font2));
            cell001.setPaddingLeft(6);
            cell001.setPaddingTop(2);
            cell001.setPaddingBottom(2);
            cell001.setColspan(15);
            cell001.setVerticalAlignment(Element.ALIGN_MIDDLE);
            cell001.setHorizontalAlignment(Element.ALIGN_LEFT);
            table01.addCell(cell001);

            PdfPCell cell002 = new PdfPCell(new Phrase("AIR DEFENSE", font7));
            cell002.setPaddingLeft(6);
            cell002.setPaddingTop(2);
            cell002.setPaddingBottom(4);
            cell002.setColspan(15);
            cell002.setVerticalAlignment(Element.ALIGN_MIDDLE);
            cell002.setHorizontalAlignment(Element.ALIGN_LEFT);
            table01.addCell(cell002);

            PdfPCell cell0001 = new PdfPCell(new Phrase("CONTRACT NUMBER", font2));
            cell0001.setPaddingLeft(6);
            cell0001.setPaddingTop(2);
            cell0001.setPaddingBottom(4);
            cell0001.setColspan(15);
            cell0001.setVerticalAlignment(Element.ALIGN_MIDDLE);
            cell0001.setHorizontalAlignment(Element.ALIGN_LEFT);
            table01.addCell(cell0001);

            PdfPCell cell0002 = new PdfPCell(new Phrase("001-MOD-INDRA-2017", font7));
            cell0002.setPaddingLeft(6);
            cell0002.setPaddingTop(2);
            cell0002.setPaddingBottom(4);
            cell0002.setColspan(15);
            cell0002.setVerticalAlignment(Element.ALIGN_MIDDLE);
            cell0002.setHorizontalAlignment(Element.ALIGN_LEFT);
            table01.addCell(cell0002);

            document.add(table01);
            Paragraph p01 = new Paragraph("\n");
            document.add(p01);

            PdfPTable table = new PdfPTable(30);
            table.setWidthPercentage(100);
            // Add PDF Table Header ->
//            Stream.of("S/N","DESCRIPTION", "SERIAL NUMBER", "PART NUMBER","DOQ", "QTY","OBSERVATION")
//                    .forEach(headerTitle -> {
//                        PdfPCell header = new PdfPCell();
//                        Font headFont = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
//                        header.setBackgroundColor(BaseColor.WHITE);
//                        header.setHorizontalAlignment(Element.ALIGN_LEFT);
////                        header.setBorderWidth(2);
//                        header.setPhrase(new Phrase(headerTitle, font2));
//                        table.addCell(header);
//                    });

//            First Cells of the table (15x 2)



            PdfPCell snnCell = new PdfPCell(new Phrase("S/N", font2));
            snnCell.setPaddingLeft(6);
            snnCell.setPaddingTop(2);
            snnCell.setPaddingBottom(6);
            snnCell.setColspan(2);
            snnCell.setVerticalAlignment(Element.ALIGN_MIDDLE);
            snnCell.setHorizontalAlignment(Element.ALIGN_LEFT);
            table.addCell(snnCell);

            PdfPCell nameeCell = new PdfPCell(new Phrase("DESCRIPTION", font2));
            nameeCell.setPaddingLeft(6);
            nameeCell.setPaddingTop(2);
            nameeCell.setPaddingBottom(6);
            nameeCell.setColspan(7);
            nameeCell.setVerticalAlignment(Element.ALIGN_MIDDLE);
            nameeCell.setHorizontalAlignment(Element.ALIGN_LEFT);
            table.addCell(nameeCell);

            PdfPCell seriallNumberCell = new PdfPCell(new Phrase("SERIAL NUMBER", font2));
            seriallNumberCell.setPaddingLeft(6);
            seriallNumberCell.setPaddingTop(2);
            seriallNumberCell.setPaddingBottom(6);
            seriallNumberCell.setColspan(6);
            seriallNumberCell.setVerticalAlignment(Element.ALIGN_MIDDLE);
            seriallNumberCell.setHorizontalAlignment(Element.ALIGN_LEFT);
            table.addCell(seriallNumberCell);

            PdfPCell partNumberrCell = new PdfPCell(new Phrase("PART NUMBER", font2));
            partNumberrCell.setVerticalAlignment(Element.ALIGN_MIDDLE);
            partNumberrCell.setHorizontalAlignment(Element.ALIGN_LEFT);
            partNumberrCell.setPaddingLeft(6);
            partNumberrCell.setPaddingTop(2);
            partNumberrCell.setPaddingBottom(6);
            partNumberrCell.setColspan(6);
            table.addCell(partNumberrCell);

            PdfPCell doqqCell = new PdfPCell(new Phrase("DOQ", font2));
            doqqCell.setVerticalAlignment(Element.ALIGN_MIDDLE);
            doqqCell.setHorizontalAlignment(Element.ALIGN_LEFT);
            doqqCell.setPaddingLeft(6);
            doqqCell.setPaddingTop(2);
            doqqCell.setPaddingBottom(6);
            doqqCell.setColspan(2);
            table.addCell(doqqCell);

            PdfPCell quantityyCell = new PdfPCell(new Phrase("QTY", font2));
            quantityyCell.setVerticalAlignment(Element.ALIGN_MIDDLE);
            quantityyCell.setHorizontalAlignment(Element.ALIGN_LEFT);
            quantityyCell.setPaddingLeft(6);
            quantityyCell.setPaddingTop(2);
            quantityyCell.setPaddingBottom(6);
            quantityyCell.setColspan(2);
            table.addCell(quantityyCell);

            PdfPCell observationnCell = new PdfPCell(new Phrase("OBSERVATION", font2));
            observationnCell.setVerticalAlignment(Element.ALIGN_MIDDLE);
            observationnCell.setHorizontalAlignment(Element.ALIGN_LEFT);
            observationnCell.setPaddingLeft(6);
            observationnCell.setPaddingTop(2);
            observationnCell.setPaddingBottom(6);
            observationnCell.setColspan(5);
            table.addCell(observationnCell);

            int i=1;

            for (SpareParts spareParts : sparePartsList) {
                PdfPCell snCell = new PdfPCell(new Phrase(String.valueOf(i), font7));
                snCell.setPaddingLeft(6);
                snCell.setPaddingTop(12);
                snCell.setPaddingBottom(14);
                snCell.setColspan(2);
                snCell.setVerticalAlignment(Element.ALIGN_MIDDLE);
                snCell.setHorizontalAlignment(Element.ALIGN_LEFT);
                table.addCell(snCell);

                PdfPCell nameCell = new PdfPCell(new Phrase(spareParts.getName(), font7));
                nameCell.setPaddingLeft(6);
                nameCell.setPaddingTop(12);
                nameCell.setPaddingBottom(14);
                nameCell.setColspan(7);
                nameCell.setVerticalAlignment(Element.ALIGN_MIDDLE);
                nameCell.setHorizontalAlignment(Element.ALIGN_LEFT);
                table.addCell(nameCell);

                PdfPCell serialNumberCell = new PdfPCell(new Phrase(spareParts.getSerialNumber(), font7));
                serialNumberCell.setPaddingLeft(6);
                serialNumberCell.setPaddingTop(12);
                serialNumberCell.setPaddingBottom(14);
                serialNumberCell.setColspan(6);
                serialNumberCell.setVerticalAlignment(Element.ALIGN_MIDDLE);
                serialNumberCell.setHorizontalAlignment(Element.ALIGN_LEFT);
                table.addCell(serialNumberCell);

                PdfPCell partNumberCell = new PdfPCell(new Phrase(spareParts.getPartNumber(), font7));
                partNumberCell.setVerticalAlignment(Element.ALIGN_MIDDLE);
                partNumberCell.setHorizontalAlignment(Element.ALIGN_LEFT);
                partNumberCell.setPaddingLeft(6);
                partNumberCell.setPaddingTop(12);
                partNumberCell.setPaddingBottom(14);
                partNumberCell.setColspan(6);
                table.addCell(partNumberCell);

                PdfPCell doqCell = new PdfPCell(new Phrase(spareParts.getDoq(), font7));
                doqCell.setVerticalAlignment(Element.ALIGN_MIDDLE);
                doqCell.setHorizontalAlignment(Element.ALIGN_LEFT);
                doqCell.setPaddingLeft(6);
                doqCell.setPaddingTop(12);
                doqCell.setPaddingBottom(14);
                doqCell.setColspan(2);
                table.addCell(doqCell);

                PdfPCell quantityCell = new PdfPCell(new Phrase(String.valueOf(spareParts.getQuantity()), font7));
                quantityCell.setVerticalAlignment(Element.ALIGN_MIDDLE);
                quantityCell.setHorizontalAlignment(Element.ALIGN_LEFT);
                quantityCell.setPaddingLeft(6);
                quantityCell.setPaddingTop(12);
                quantityCell.setPaddingBottom(14);
                quantityCell.setColspan(2);
                table.addCell(quantityCell);

                PdfPCell observationCell = new PdfPCell(new Phrase(spareParts.getObservation(), font7));
                observationCell.setVerticalAlignment(Element.ALIGN_MIDDLE);
                observationCell.setHorizontalAlignment(Element.ALIGN_LEFT);
                observationCell.setPaddingLeft(6);
                observationCell.setPaddingTop(12);
                observationCell.setPaddingBottom(14);
                observationCell.setColspan(5);
                table.addCell(observationCell);
                i=i+1;
            }

            document.add(table);
            Paragraph p = new Paragraph("\n\n");
            document.add(p);


            PdfPTable table2 = new PdfPTable(3);
            table2.setWidthPercentage(100);
            // Add PDF Table Header ->
            Stream.of("LOG STAFF", "761 Sqn Head Tech", "Ag761 Sqn Commander")
                    .forEach(headerTitle -> {
                        PdfPCell header = new PdfPCell();
                        Font headFont = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
                        header.setBackgroundColor(BaseColor.WHITE);
                        header.setHorizontalAlignment(Element.ALIGN_LEFT);
                        header.setPaddingBottom(14);
                        header.setPaddingLeft(6);
//                        header.setBorderWidth(2);
                        header.setPhrase(new Phrase(headerTitle, font5));
                        table2.addCell(header);
                    });


                PdfPCell cell1 = new PdfPCell(new Phrase("\n....................................\n\nKABONERO Gad\n\nCpl\n\n", font7));
                cell1.setPaddingLeft(6);
                cell1.setVerticalAlignment(Element.ALIGN_MIDDLE);
                cell1.setHorizontalAlignment(Element.ALIGN_LEFT);
                table2.addCell(cell1);

                PdfPCell cell2 = new PdfPCell(new Phrase("\n....................................\n\nE UWIKUZO\n\nLt\n\n", font7));
                cell2.setPaddingLeft(6);
                cell2.setVerticalAlignment(Element.ALIGN_MIDDLE);
                cell2.setHorizontalAlignment(Element.ALIGN_LEFT);
                table2.addCell(cell2);

                PdfPCell cell3 = new PdfPCell(new Phrase("\n....................................\n\nD NSENGIYAREMYE\n\nLt\n\n", font7));
                cell3.setVerticalAlignment(Element.ALIGN_MIDDLE);
                cell3.setHorizontalAlignment(Element.ALIGN_LEFT);
                cell3.setPaddingLeft(6);
                table2.addCell(cell3);




            document.add(table2);
            document.close();

        }catch(DocumentException e) {
            logger.error(e.toString());
        }

        return new ByteArrayInputStream(out.toByteArray());
    }

    public static ByteArrayInputStream ordersPDFReport(List<Orders> ordersList)  throws DocumentException, MalformedURLException, IOException {
        Document document = new Document(PageSize.A4_LANDSCAPE, 10f, 10f, 10f, 0f);
        Rectangle rect = new Rectangle(20, 20, 800, 800);
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        PdfWriter writer = PdfWriter.getInstance(document, out);
        writer.setBoxSize("art", rect);
        document.setPageSize(rect);
        if (!document.isOpen()) {
            document.open();
        }
        try {

            PdfWriter.getInstance(document, out);
            document.open();

            Image img = Image.getInstance("src/main/resources/static/logo.png");
            img.scaleAbsolute(60f, 60f);
            img.setAlignment(Element.ALIGN_CENTER);

            Font font = FontFactory.getFont(FontFactory.COURIER, 14, BaseColor.BLACK);
            Font font0 = new Font(Font.FontFamily.TIMES_ROMAN, 14, Font.UNDERLINE);
            Font font1 = new Font(Font.FontFamily.TIMES_ROMAN, 9, Font.BOLD);
            Font font2 = new Font(Font.FontFamily.TIMES_ROMAN, 12, Font.BOLD);
            Font font5 = new Font(Font.FontFamily.TIMES_ROMAN, 12);
            Font font6 = new Font(Font.FontFamily.TIMES_ROMAN, 11, Font.ITALIC);
            Font font7 = new Font(Font.FontFamily.TIMES_ROMAN, 11);
            Font font8 = new Font(Font.FontFamily.TIMES_ROMAN, 12, Font.UNDERLINE);

           Paragraph newSpace= new Paragraph("\n\n");
           document.add(newSpace);


            PdfPTable tableh1 = new PdfPTable(1);
            tableh1.setWidthPercentage(90);
            // Add PDF Table Header ->

            PdfPCell hh1 = new PdfPCell(new Phrase("7AD JALI SPARE PARTS TRANSACTIONS", font2));
            hh1.setPaddingTop(2);
            hh1.setPaddingBottom(4);
            hh1.setVerticalAlignment(Element.ALIGN_MIDDLE);
            hh1.setHorizontalAlignment(Element.ALIGN_CENTER);
            tableh1.addCell(hh1);

            PdfPCell hh2 = new PdfPCell(new Phrase("RADAR SPARE PARTS SENT TO SPAIN FOR REPAIR", font2));
            hh2.setPaddingTop(2);
            hh2.setPaddingBottom(4);
            hh2.setBackgroundColor(BaseColor.GRAY);
            hh2.setVerticalAlignment(Element.ALIGN_MIDDLE);
            hh2.setHorizontalAlignment(Element.ALIGN_CENTER);
            tableh1.addCell(hh2);


            PdfPTable table = new PdfPTable(34);
            table.setWidthPercentage(90);
            // Add PDF Table Header ->

            PdfPCell snnCell = new PdfPCell(new Phrase("S/No", font2));
            snnCell.setPaddingLeft(6);
            snnCell.setPaddingTop(2);
            snnCell.setPaddingBottom(4);
            snnCell.setColspan(2);
            snnCell.setVerticalAlignment(Element.ALIGN_MIDDLE);
            snnCell.setHorizontalAlignment(Element.ALIGN_LEFT);
            table.addCell(snnCell);

            PdfPCell descCell = new PdfPCell(new Phrase("DESCRIPTION", font2));
            descCell.setPaddingLeft(6);
            descCell.setPaddingTop(2);
            descCell.setPaddingBottom(4);
            descCell.setColspan(8);
            descCell.setVerticalAlignment(Element.ALIGN_MIDDLE);
            descCell.setHorizontalAlignment(Element.ALIGN_LEFT);
            table.addCell(descCell);

            PdfPCell partNumberrCell = new PdfPCell(new Phrase("P/No", font2));
            partNumberrCell.setVerticalAlignment(Element.ALIGN_MIDDLE);
            partNumberrCell.setHorizontalAlignment(Element.ALIGN_LEFT);
            partNumberrCell.setPaddingLeft(6);
            partNumberrCell.setPaddingTop(2);
            partNumberrCell.setPaddingBottom(4);
            partNumberrCell.setColspan(6);
            table.addCell(partNumberrCell);

            PdfPCell seriallNumberCell = new PdfPCell(new Phrase("S/No", font2));
            seriallNumberCell.setPaddingLeft(6);
            seriallNumberCell.setPaddingTop(2);
            seriallNumberCell.setPaddingBottom(4);
            seriallNumberCell.setColspan(6);
            seriallNumberCell.setVerticalAlignment(Element.ALIGN_MIDDLE);
            seriallNumberCell.setHorizontalAlignment(Element.ALIGN_LEFT);
            table.addCell(seriallNumberCell);

            PdfPCell quantityyCell = new PdfPCell(new Phrase("QTY", font2));
            quantityyCell.setVerticalAlignment(Element.ALIGN_MIDDLE);
            quantityyCell.setHorizontalAlignment(Element.ALIGN_LEFT);
            quantityyCell.setPaddingLeft(6);
            quantityyCell.setPaddingTop(2);
            quantityyCell.setPaddingBottom(4);
            quantityyCell.setColspan(2);
            table.addCell(quantityyCell);

            PdfPCell rmkCell = new PdfPCell(new Phrase("REMARKS", font2));
            rmkCell.setVerticalAlignment(Element.ALIGN_MIDDLE);
            rmkCell.setHorizontalAlignment(Element.ALIGN_LEFT);
            rmkCell.setPaddingLeft(6);
            rmkCell.setPaddingTop(2);
            rmkCell.setPaddingBottom(4);
            rmkCell.setColspan(10);
            table.addCell(rmkCell);

            int i =1;

            for (Orders orders : ordersList) {

                PdfPCell iCell = new PdfPCell(new Phrase(String.valueOf(i), font7));
                iCell.setVerticalAlignment(Element.ALIGN_MIDDLE);
                iCell.setHorizontalAlignment(Element.ALIGN_LEFT);
                iCell.setPaddingLeft(4);
                iCell.setColspan(2);
                table.addCell(iCell);

                PdfPCell descriptionCell = new PdfPCell(new Phrase(orders.getDescription(), font7));
                descriptionCell.setVerticalAlignment(Element.ALIGN_MIDDLE);
                descriptionCell.setHorizontalAlignment(Element.ALIGN_LEFT);
                descriptionCell.setPaddingLeft(4);
                descriptionCell.setColspan(8);
                table.addCell(descriptionCell);

                PdfPCell pnCell = new PdfPCell(new Phrase(String.valueOf(orders.getPartNumber()), font7));
                pnCell.setVerticalAlignment(Element.ALIGN_MIDDLE);
                pnCell.setHorizontalAlignment(Element.ALIGN_LEFT);
                pnCell.setPaddingLeft(4);
                pnCell.setColspan(6);
                table.addCell(pnCell);

                PdfPCell snCell = new PdfPCell(new Phrase(String.valueOf(orders.getSerialNumber()), font7));
                snCell.setVerticalAlignment(Element.ALIGN_MIDDLE);
                snCell.setHorizontalAlignment(Element.ALIGN_LEFT);
                snCell.setPaddingLeft(4);
                snCell.setColspan(6);
                table.addCell(snCell);

                PdfPCell quantityCell = new PdfPCell(new Phrase(String.valueOf(orders.getQuantity()), font7));
                quantityCell.setVerticalAlignment(Element.ALIGN_MIDDLE);
                quantityCell.setHorizontalAlignment(Element.ALIGN_LEFT);
                quantityCell.setPaddingLeft(4);
                quantityCell.setColspan(2);
                table.addCell(quantityCell);

                PdfPCell remarksCell = new PdfPCell(new Phrase(orders.getRemarks(), font7));
                remarksCell.setVerticalAlignment(Element.ALIGN_MIDDLE);
                remarksCell.setHorizontalAlignment(Element.ALIGN_LEFT);
                remarksCell.setPaddingLeft(4);
                remarksCell.setColspan(10);
                table.addCell(remarksCell);
                i=i+1;

            }
            document.add(tableh1);
            document.add(table);

            document.close();

        }catch(DocumentException e) {
            logger.error(e.toString());
        }

        return new ByteArrayInputStream(out.toByteArray());
    }

    public static ByteArrayInputStream pendingOrdersPDFReport(List<Orders> ordersList)  throws DocumentException, MalformedURLException, IOException {
        Document document = new Document(PageSize.A4_LANDSCAPE, 10f, 10f, 10f, 0f);
        Rectangle rect = new Rectangle(20, 20, 800, 800);
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        PdfWriter writer = PdfWriter.getInstance(document, out);
        writer.setBoxSize("art", rect);
        document.setPageSize(rect);
        if (!document.isOpen()) {
            document.open();
        }
        try {

            PdfWriter.getInstance(document, out);
            document.open();

            Image img = Image.getInstance("src/main/resources/static/logo.png");
            img.scaleAbsolute(60f, 60f);
            img.setAlignment(Element.ALIGN_CENTER);

            Font font = FontFactory.getFont(FontFactory.COURIER, 14, BaseColor.BLACK);
            Font font0 = new Font(Font.FontFamily.TIMES_ROMAN, 14, Font.UNDERLINE);
            Font font1 = new Font(Font.FontFamily.TIMES_ROMAN, 9, Font.BOLD);
            Font font2 = new Font(Font.FontFamily.TIMES_ROMAN, 12, Font.BOLD);
            Font font5 = new Font(Font.FontFamily.TIMES_ROMAN, 12);
            Font font6 = new Font(Font.FontFamily.TIMES_ROMAN, 11, Font.ITALIC);
            Font font7 = new Font(Font.FontFamily.TIMES_ROMAN, 11);
            Font font8 = new Font(Font.FontFamily.TIMES_ROMAN, 12, Font.UNDERLINE);

            Paragraph newSpace= new Paragraph("\n\n");
            document.add(newSpace);


            PdfPTable tableh1 = new PdfPTable(1);
            tableh1.setWidthPercentage(90);
            // Add PDF Table Header ->


            PdfPCell hh2 = new PdfPCell(new Phrase("MATERIALS PENDING TO BE REPAIRED", font2));
            hh2.setPaddingTop(2);
            hh2.setPaddingBottom(4);
            hh2.setBackgroundColor(BaseColor.GRAY);
            hh2.setVerticalAlignment(Element.ALIGN_MIDDLE);
            hh2.setHorizontalAlignment(Element.ALIGN_CENTER);
            tableh1.addCell(hh2);


            PdfPTable table = new PdfPTable(34);
            table.setWidthPercentage(90);
            // Add PDF Table Header ->

            PdfPCell snnCell = new PdfPCell(new Phrase("S/No", font2));
            snnCell.setPaddingLeft(6);
            snnCell.setPaddingTop(2);
            snnCell.setPaddingBottom(4);
            snnCell.setColspan(2);
            snnCell.setVerticalAlignment(Element.ALIGN_MIDDLE);
            snnCell.setHorizontalAlignment(Element.ALIGN_LEFT);
            table.addCell(snnCell);

            PdfPCell descCell = new PdfPCell(new Phrase("DESCRIPTION", font2));
            descCell.setPaddingLeft(6);
            descCell.setPaddingTop(2);
            descCell.setPaddingBottom(4);
            descCell.setColspan(8);
            descCell.setVerticalAlignment(Element.ALIGN_MIDDLE);
            descCell.setHorizontalAlignment(Element.ALIGN_LEFT);
            table.addCell(descCell);

            PdfPCell partNumberrCell = new PdfPCell(new Phrase("P/No", font2));
            partNumberrCell.setVerticalAlignment(Element.ALIGN_MIDDLE);
            partNumberrCell.setHorizontalAlignment(Element.ALIGN_LEFT);
            partNumberrCell.setPaddingLeft(6);
            partNumberrCell.setPaddingTop(2);
            partNumberrCell.setPaddingBottom(4);
            partNumberrCell.setColspan(6);
            table.addCell(partNumberrCell);

            PdfPCell seriallNumberCell = new PdfPCell(new Phrase("S/No", font2));
            seriallNumberCell.setPaddingLeft(6);
            seriallNumberCell.setPaddingTop(2);
            seriallNumberCell.setPaddingBottom(4);
            seriallNumberCell.setColspan(6);
            seriallNumberCell.setVerticalAlignment(Element.ALIGN_MIDDLE);
            seriallNumberCell.setHorizontalAlignment(Element.ALIGN_LEFT);
            table.addCell(seriallNumberCell);

            PdfPCell quantityyCell = new PdfPCell(new Phrase("QTY", font2));
            quantityyCell.setVerticalAlignment(Element.ALIGN_MIDDLE);
            quantityyCell.setHorizontalAlignment(Element.ALIGN_LEFT);
            quantityyCell.setPaddingLeft(6);
            quantityyCell.setPaddingTop(2);
            quantityyCell.setPaddingBottom(4);
            quantityyCell.setColspan(2);
            table.addCell(quantityyCell);

            PdfPCell rmkCell = new PdfPCell(new Phrase("REMARKS", font2));
            rmkCell.setVerticalAlignment(Element.ALIGN_MIDDLE);
            rmkCell.setHorizontalAlignment(Element.ALIGN_LEFT);
            rmkCell.setPaddingLeft(6);
            rmkCell.setPaddingTop(2);
            rmkCell.setPaddingBottom(4);
            rmkCell.setColspan(10);
            table.addCell(rmkCell);

            int i =1;

            for (Orders orders : ordersList) {

                PdfPCell iCell = new PdfPCell(new Phrase(String.valueOf(i), font7));
                iCell.setVerticalAlignment(Element.ALIGN_MIDDLE);
                iCell.setHorizontalAlignment(Element.ALIGN_LEFT);
                iCell.setPaddingLeft(4);
                iCell.setColspan(2);
                table.addCell(iCell);

                PdfPCell descriptionCell = new PdfPCell(new Phrase(orders.getDescription(), font7));
                descriptionCell.setVerticalAlignment(Element.ALIGN_MIDDLE);
                descriptionCell.setHorizontalAlignment(Element.ALIGN_LEFT);
                descriptionCell.setPaddingLeft(4);
                descriptionCell.setColspan(8);
                table.addCell(descriptionCell);

                PdfPCell pnCell = new PdfPCell(new Phrase(String.valueOf(orders.getPartNumber()), font7));
                pnCell.setVerticalAlignment(Element.ALIGN_MIDDLE);
                pnCell.setHorizontalAlignment(Element.ALIGN_LEFT);
                pnCell.setPaddingLeft(4);
                pnCell.setColspan(6);
                table.addCell(pnCell);

                PdfPCell snCell = new PdfPCell(new Phrase(String.valueOf(orders.getSerialNumber()), font7));
                snCell.setVerticalAlignment(Element.ALIGN_MIDDLE);
                snCell.setHorizontalAlignment(Element.ALIGN_LEFT);
                snCell.setPaddingLeft(4);
                snCell.setColspan(6);
                table.addCell(snCell);

                PdfPCell quantityCell = new PdfPCell(new Phrase(String.valueOf(orders.getQuantity()), font7));
                quantityCell.setVerticalAlignment(Element.ALIGN_MIDDLE);
                quantityCell.setHorizontalAlignment(Element.ALIGN_LEFT);
                quantityCell.setPaddingLeft(4);
                quantityCell.setColspan(2);
                table.addCell(quantityCell);

                PdfPCell remarksCell = new PdfPCell(new Phrase(orders.getRemarks(), font7));
                remarksCell.setVerticalAlignment(Element.ALIGN_MIDDLE);
                remarksCell.setHorizontalAlignment(Element.ALIGN_LEFT);
                remarksCell.setPaddingLeft(4);
                remarksCell.setColspan(10);
                table.addCell(remarksCell);
                i=i+1;

            }
            document.add(tableh1);
            document.add(table);

            document.close();

        }catch(DocumentException e) {
            logger.error(e.toString());
        }

        return new ByteArrayInputStream(out.toByteArray());
    }

    public static ByteArrayInputStream packingListPDFReport(List<Packing> packingList)  throws DocumentException, MalformedURLException, IOException {
        Document document = new Document();
        Rectangle rect = new Rectangle(20, 20, 800, 800);
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        PdfWriter writer = PdfWriter.getInstance(document, out);
        writer.setBoxSize("art", rect);
        document.setPageSize(rect);
        if (!document.isOpen()) {
            document.open();
        }
        try {

            PdfWriter.getInstance(document, out);
            document.open();

            Image img = Image.getInstance("src/main/resources/static/logo.png");
            img.scaleAbsolute(60f, 60f);
            img.setAlignment(Element.ALIGN_CENTER);

            Font font = FontFactory.getFont(FontFactory.COURIER, 14, BaseColor.BLACK);
            Font font0 = new Font(Font.FontFamily.TIMES_ROMAN, 14, Font.UNDERLINE);
            Font font1 = new Font(Font.FontFamily.TIMES_ROMAN, 9, Font.BOLD);
            Font font2 = new Font(Font.FontFamily.TIMES_ROMAN, 12, Font.BOLD);
            Font font5 = new Font(Font.FontFamily.TIMES_ROMAN, 12);
            Font font6 = new Font(Font.FontFamily.TIMES_ROMAN, 11, Font.ITALIC);
            Font font7 = new Font(Font.FontFamily.TIMES_ROMAN, 11);
            Font font8 = new Font(Font.FontFamily.TIMES_ROMAN, 12, Font.UNDERLINE);

            Paragraph newSpace= new Paragraph("\n");
            document.add(img);
            document.add(newSpace);

            PdfPTable tableh1 = new PdfPTable(34);
            tableh1.setWidthPercentage(90);
            // Add PDF Table Header ->


            PdfPCell hh2 = new PdfPCell(new Phrase("PACKING LIST", font2));
            hh2.setPaddingTop(2);
            hh2.setPaddingBottom(4);
            hh2.setColspan(34);
            hh2.setVerticalAlignment(Element.ALIGN_MIDDLE);
            hh2.setHorizontalAlignment(Element.ALIGN_CENTER);
            tableh1.addCell(hh2);

            PdfPCell consCell = new PdfPCell(new Phrase("CONSIGNOR", font2));
            consCell.setPaddingTop(2);
            consCell.setPaddingBottom(4);
            consCell.setColspan(14);
            consCell.setVerticalAlignment(Element.ALIGN_MIDDLE);
            tableh1.addCell(consCell);

            PdfPCell conssCell = new PdfPCell(new Phrase("CONSIGNEE", font2));
            conssCell.setPaddingTop(2);
            conssCell.setPaddingBottom(4);
            conssCell.setColspan(20);
            conssCell.setVerticalAlignment(Element.ALIGN_MIDDLE);
            tableh1.addCell(conssCell);

            PdfPCell modCell = new PdfPCell(new Phrase("MINISTRY OF DEFENCE", font2));
            modCell.setPaddingTop(2);
            modCell.setPaddingBottom(4);
            modCell.setColspan(14);
            modCell.setVerticalAlignment(Element.ALIGN_MIDDLE);
            tableh1.addCell(modCell);

            PdfPCell indraCell = new PdfPCell(new Phrase("INDRA SISTEMAS SA", font2));
            indraCell.setPaddingTop(2);
            indraCell.setPaddingBottom(4);
            indraCell.setColspan(20);
            indraCell.setVerticalAlignment(Element.ALIGN_MIDDLE);
            tableh1.addCell(indraCell);

            PdfPCell kigaliCell = new PdfPCell(new Phrase("KIGALI / RWANDA", font2));
            kigaliCell.setPaddingTop(2);
            kigaliCell.setPaddingBottom(4);
            kigaliCell.setColspan(14);
            kigaliCell.setVerticalAlignment(Element.ALIGN_MIDDLE);
            tableh1.addCell(kigaliCell);

            PdfPCell centroCell = new PdfPCell(new Phrase("CENTRO LOGISTICO DE TRANSIMISION DEL", font2));
            centroCell.setPaddingTop(2);
            centroCell.setPaddingBottom(4);
            centroCell.setColspan(20);
            centroCell.setVerticalAlignment(Element.ALIGN_MIDDLE);
            tableh1.addCell(centroCell);

            PdfPCell airCell = new PdfPCell(new Phrase("AIR DEFENCE, KIGALI", font2));
            airCell.setPaddingTop(2);
            airCell.setPaddingBottom(4);
            airCell.setColspan(14);
            airCell.setVerticalAlignment(Element.ALIGN_MIDDLE);
            tableh1.addCell(airCell);

            PdfPCell delAirCell = new PdfPCell(new Phrase("EJERCITO DEL AIRE", font2));
            delAirCell.setPaddingTop(2);
            delAirCell.setPaddingBottom(4);
            delAirCell.setColspan(20);
            delAirCell.setVerticalAlignment(Element.ALIGN_MIDDLE);
            tableh1.addCell(delAirCell);

            PdfPCell logCell = new PdfPCell(new Phrase("LOGISTIC DEPARTMENT", font2));
            logCell.setPaddingTop(2);
            logCell.setPaddingBottom(4);
            logCell.setColspan(14);
            logCell.setVerticalAlignment(Element.ALIGN_MIDDLE);
            tableh1.addCell(logCell);

            PdfPCell log2Cell = new PdfPCell(new Phrase("AV. JOHN LENNON S/N", font2));
            log2Cell.setPaddingTop(2);
            log2Cell.setPaddingBottom(4);
            log2Cell.setColspan(20);
            log2Cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
            tableh1.addCell(log2Cell);

            PdfPCell telCell = new PdfPCell(new Phrase("Tel: +250 788748187", font2));
            telCell.setPaddingTop(2);
            telCell.setPaddingBottom(4);
            telCell.setColspan(14);
            telCell.setVerticalAlignment(Element.ALIGN_MIDDLE);
            tableh1.addCell(telCell);

            PdfPCell addressCell = new PdfPCell(new Phrase("28906 - GETATE(MADRID)", font2));
            addressCell.setPaddingTop(2);
            addressCell.setPaddingBottom(4);
            addressCell.setColspan(20);
            addressCell.setVerticalAlignment(Element.ALIGN_MIDDLE);
            tableh1.addCell(addressCell);

            PdfPCell emailCell = new PdfPCell(new Phrase("7asssqncond@minadef@gov.rw", font2));
            emailCell.setPaddingTop(2);
            emailCell.setPaddingBottom(4);
            emailCell.setColspan(14);
            emailCell.setVerticalAlignment(Element.ALIGN_MIDDLE);
            tableh1.addCell(emailCell);

            PdfPCell countryCell = new PdfPCell(new Phrase("SPAIN", font2));
            countryCell.setPaddingTop(2);
            countryCell.setPaddingBottom(4);
            countryCell.setColspan(20);
            countryCell.setVerticalAlignment(Element.ALIGN_MIDDLE);
            tableh1.addCell(countryCell);

            PdfPCell emptyCell = new PdfPCell();
            emptyCell.setPaddingTop(2);
            emptyCell.setPaddingBottom(4);
            emptyCell.setColspan(14);
            emptyCell.setVerticalAlignment(Element.ALIGN_MIDDLE);
            tableh1.addCell(emptyCell);

            PdfPCell commentCell = new PdfPCell(new Phrase("NOTIFY ARRIVAL OF GOODS TO DSV AIR & SEA (Barajas.Aduanas@es.dsv.com or javier.cobertera@es.dsv.com)", font2));
            commentCell.setPaddingTop(6);
            commentCell.setPaddingBottom(10);
            commentCell.setColspan(20);
            commentCell.setVerticalAlignment(Element.ALIGN_MIDDLE);
            tableh1.addCell(commentCell);

            PdfPTable table = new PdfPTable(34);
            table.setWidthPercentage(90);
            // Add PDF Table Header ->

            PdfPCell snnCell = new PdfPCell(new Phrase("S/N", font2));
            snnCell.setPaddingLeft(6);
            snnCell.setPaddingTop(2);
            snnCell.setPaddingBottom(4);
            snnCell.setColspan(2);
            snnCell.setVerticalAlignment(Element.ALIGN_MIDDLE);
            snnCell.setHorizontalAlignment(Element.ALIGN_LEFT);
            table.addCell(snnCell);


            PdfPCell partNumberrCell = new PdfPCell(new Phrase("Part No", font2));
            partNumberrCell.setVerticalAlignment(Element.ALIGN_MIDDLE);
            partNumberrCell.setHorizontalAlignment(Element.ALIGN_LEFT);
            partNumberrCell.setPaddingLeft(6);
            partNumberrCell.setPaddingTop(2);
            partNumberrCell.setPaddingBottom(4);
            partNumberrCell.setColspan(6);
            table.addCell(partNumberrCell);

            PdfPCell seriallNumberCell = new PdfPCell(new Phrase("Serial No", font2));
            seriallNumberCell.setPaddingLeft(6);
            seriallNumberCell.setPaddingTop(2);
            seriallNumberCell.setPaddingBottom(4);
            seriallNumberCell.setColspan(6);
            seriallNumberCell.setVerticalAlignment(Element.ALIGN_MIDDLE);
            seriallNumberCell.setHorizontalAlignment(Element.ALIGN_LEFT);
            table.addCell(seriallNumberCell);

            PdfPCell descCell = new PdfPCell(new Phrase("DESCRIPTION", font2));
            descCell.setPaddingLeft(6);
            descCell.setPaddingTop(2);
            descCell.setPaddingBottom(4);
            descCell.setColspan(6);
            descCell.setVerticalAlignment(Element.ALIGN_MIDDLE);
            descCell.setHorizontalAlignment(Element.ALIGN_LEFT);
            table.addCell(descCell);

            PdfPCell quantityyCell = new PdfPCell(new Phrase("QTY", font2));
            quantityyCell.setVerticalAlignment(Element.ALIGN_MIDDLE);
            quantityyCell.setHorizontalAlignment(Element.ALIGN_LEFT);
            quantityyCell.setPaddingLeft(6);
            quantityyCell.setPaddingTop(2);
            quantityyCell.setPaddingBottom(4);
            quantityyCell.setColspan(2);
            table.addCell(quantityyCell);

            PdfPCell weightCell = new PdfPCell(new Phrase("Weight", font2));
            weightCell.setVerticalAlignment(Element.ALIGN_MIDDLE);
            weightCell.setHorizontalAlignment(Element.ALIGN_LEFT);
            weightCell.setPaddingLeft(6);
            weightCell.setPaddingTop(2);
            weightCell.setPaddingBottom(4);
            weightCell.setColspan(3);
            table.addCell(weightCell);

            PdfPCell dimCell = new PdfPCell(new Phrase("DIM", font2));
            dimCell.setVerticalAlignment(Element.ALIGN_MIDDLE);
            dimCell.setHorizontalAlignment(Element.ALIGN_LEFT);
            dimCell.setPaddingLeft(6);
            dimCell.setPaddingTop(2);
            dimCell.setPaddingBottom(4);
            dimCell.setColspan(5);
            table.addCell(dimCell);

            PdfPCell rmkCell = new PdfPCell(new Phrase("REMARKS", font2));
            rmkCell.setVerticalAlignment(Element.ALIGN_MIDDLE);
            rmkCell.setHorizontalAlignment(Element.ALIGN_LEFT);
            rmkCell.setPaddingLeft(6);
            rmkCell.setPaddingTop(2);
            rmkCell.setPaddingBottom(4);
            rmkCell.setColspan(9);
            table.addCell(rmkCell);

            int i =1;

            for (Packing packing : packingList) {

                PdfPCell iCell = new PdfPCell(new Phrase(String.valueOf(i), font7));
                iCell.setVerticalAlignment(Element.ALIGN_MIDDLE);
                iCell.setHorizontalAlignment(Element.ALIGN_LEFT);
                iCell.setPaddingLeft(4);
                iCell.setColspan(2);
                table.addCell(iCell);

                PdfPCell pnCell = new PdfPCell(new Phrase(String.valueOf(packing.getPartNumber()), font7));
                pnCell.setVerticalAlignment(Element.ALIGN_MIDDLE);
                pnCell.setHorizontalAlignment(Element.ALIGN_LEFT);
                pnCell.setPaddingLeft(4);
                pnCell.setColspan(6);
                table.addCell(pnCell);

                PdfPCell snCell = new PdfPCell(new Phrase(packing.getSerialNumber(), font7));
                snCell.setVerticalAlignment(Element.ALIGN_MIDDLE);
                snCell.setHorizontalAlignment(Element.ALIGN_LEFT);
                snCell.setPaddingLeft(4);
                snCell.setColspan(6);
                table.addCell(snCell);

                PdfPCell descriptionCell = new PdfPCell(new Phrase(packing.getDescription(), font7));
                descriptionCell.setVerticalAlignment(Element.ALIGN_MIDDLE);
                descriptionCell.setHorizontalAlignment(Element.ALIGN_LEFT);
                descriptionCell.setPaddingLeft(4);
                descriptionCell.setColspan(6);
                table.addCell(descriptionCell);

                PdfPCell quantityCell = new PdfPCell(new Phrase(String.valueOf(packing.getQuantity()), font7));
                quantityCell.setVerticalAlignment(Element.ALIGN_MIDDLE);
                quantityCell.setHorizontalAlignment(Element.ALIGN_LEFT);
                quantityCell.setPaddingLeft(4);
                quantityCell.setColspan(2);
                table.addCell(quantityCell);

                PdfPCell wghtCell = new PdfPCell(new Phrase(packing.getWeight(), font7));
                wghtCell.setVerticalAlignment(Element.ALIGN_MIDDLE);
                wghtCell.setHorizontalAlignment(Element.ALIGN_LEFT);
                wghtCell.setPaddingLeft(4);
                wghtCell.setColspan(3);
                table.addCell(wghtCell);

                PdfPCell dimmCell = new PdfPCell(new Phrase(packing.getDim(), font7));
                dimmCell.setVerticalAlignment(Element.ALIGN_MIDDLE);
                dimmCell.setHorizontalAlignment(Element.ALIGN_LEFT);
                dimmCell.setPaddingLeft(4);
                dimmCell.setColspan(5);
                table.addCell(dimmCell);

                PdfPCell remarksCell = new PdfPCell(new Phrase(packing.getRemarks(), font7));
                remarksCell.setVerticalAlignment(Element.ALIGN_MIDDLE);
                remarksCell.setHorizontalAlignment(Element.ALIGN_LEFT);
                remarksCell.setPaddingLeft(4);
                remarksCell.setColspan(9);
                table.addCell(remarksCell);
                i=i+1;

            }

            PdfPTable tableh3 = new PdfPTable(34);
            tableh3.setWidthPercentage(90);

            Chunk chunk1= new Chunk("Prepared by:  ", font7);
            Chunk chunk2 = new Chunk("Lt Innocent IKIRENGA", font2);

            Phrase phrase = new Phrase();
            phrase.add(chunk1);
            phrase.add(chunk2);

            PdfPCell oneCell = new PdfPCell(phrase);
            oneCell.setPaddingLeft(6);
            oneCell.setPaddingTop(2);
            oneCell.setPaddingBottom(4);
            oneCell.setColspan(14);
            oneCell.setVerticalAlignment(Element.ALIGN_MIDDLE);
            oneCell.setHorizontalAlignment(Element.ALIGN_LEFT);
            tableh3.addCell(oneCell);

            PdfPCell emptyCell1 = new PdfPCell();
            emptyCell1.setPaddingLeft(6);
            emptyCell1.setPaddingTop(2);
            emptyCell1.setBorder(Rectangle.NO_BORDER);
            emptyCell1.setColspan(20);
            emptyCell1.setVerticalAlignment(Element.ALIGN_MIDDLE);
            emptyCell1.setHorizontalAlignment(Element.ALIGN_LEFT);
            tableh3.addCell(emptyCell1);

            PdfPCell twoCell = new PdfPCell(new Phrase("Tel: +250 785190471", font7));
            twoCell.setPaddingLeft(6);
            twoCell.setPaddingTop(2);
            twoCell.setPaddingBottom(4);
            twoCell.setColspan(14);
            twoCell.setVerticalAlignment(Element.ALIGN_MIDDLE);
            twoCell.setHorizontalAlignment(Element.ALIGN_LEFT);
            tableh3.addCell(twoCell);

            PdfPCell emptyCell2 = new PdfPCell();
            emptyCell2.setPaddingLeft(6);
            emptyCell2.setPaddingTop(2);
            emptyCell2.setBorder(Rectangle.NO_BORDER);
            emptyCell2.setColspan(20);
            emptyCell2.setVerticalAlignment(Element.ALIGN_MIDDLE);
            emptyCell2.setHorizontalAlignment(Element.ALIGN_LEFT);
            tableh3.addCell(emptyCell2);

            PdfPCell threeCell = new PdfPCell(new Phrase("Date: 26/09/2022", font7));
            threeCell.setPaddingLeft(6);
            threeCell.setPaddingTop(2);
            threeCell.setPaddingBottom(4);
            threeCell.setColspan(14);
            threeCell.setVerticalAlignment(Element.ALIGN_MIDDLE);
            threeCell.setHorizontalAlignment(Element.ALIGN_LEFT);
            tableh3.addCell(threeCell);

            PdfPCell emptyCell3 = new PdfPCell();
            emptyCell3.setPaddingLeft(6);
            emptyCell3.setPaddingTop(2);
            emptyCell3.setBorder(Rectangle.NO_BORDER);
            emptyCell3.setColspan(20);
            emptyCell3.setVerticalAlignment(Element.ALIGN_MIDDLE);
            emptyCell3.setHorizontalAlignment(Element.ALIGN_LEFT);
            tableh3.addCell(emptyCell3);


            document.add(tableh1);
            document.add(table);
            Paragraph space3= new Paragraph("\n\n");
            document.add(space3);
            document.add(tableh3);

            document.close();

        }catch(DocumentException e) {
            logger.error(e.toString());
        }

        return new ByteArrayInputStream(out.toByteArray());
    }

}