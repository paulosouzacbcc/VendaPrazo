/**
 * Example written by Bruno Lowagie and Nishanthi Grashia in answer to the following question:
 * http://stackoverflow.com/questions/24359321/adding-row-to-a-table-in-pdf-using-itext
 */
package util;

import com.itextpdf.text.Chapter;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import controller.ControllerVenda;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import model.Venda;

public class GeneratorPDF {

    //public static final String DEST = "/home/maverick/Downloads/testePDF/teste.pdf";
    public static final String DEST = "/home/maverick/Downloads/testePDF/" + Texto.formataDataPraPDF(new Date());

    public static void main(String[] args) throws IOException, DocumentException {

        File file = new File(DEST);
        file.getParentFile().mkdirs();
        new GeneratorPDF().createPdf(DEST);
    }

    public void createPdf(String dest) throws IOException, DocumentException {

        List<Venda> vendas = new List<Venda>() {
            @Override
            public int size() {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public boolean isEmpty() {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public boolean contains(Object o) {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public Iterator<Venda> iterator() {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public Object[] toArray() {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public <T> T[] toArray(T[] a) {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public boolean add(Venda e) {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public boolean remove(Object o) {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public boolean containsAll(Collection<?> c) {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public boolean addAll(Collection<? extends Venda> c) {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public boolean addAll(int index, Collection<? extends Venda> c) {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public boolean removeAll(Collection<?> c) {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public boolean retainAll(Collection<?> c) {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public void clear() {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public Venda get(int index) {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public Venda set(int index, Venda element) {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public void add(int index, Venda element) {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public Venda remove(int index) {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public int indexOf(Object o) {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public int lastIndexOf(Object o) {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public ListIterator<Venda> listIterator() {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public ListIterator<Venda> listIterator(int index) {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public List<Venda> subList(int fromIndex, int toIndex) {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }
        };

        ControllerVenda controllerVenda = new ControllerVenda();

        vendas = controllerVenda.getVendaList();
        int size = vendas.size();

        Document document = new Document();
        PdfWriter.getInstance(document, new FileOutputStream(dest));
        document.open();

        //Adicionando Titulo
        Font chapterFont = FontFactory.getFont(FontFactory.HELVETICA, 16, Font.BOLDITALIC);
        Font paragraphFont = FontFactory.getFont(FontFactory.HELVETICA, 12, Font.NORMAL);

        Chunk chunk = new Chunk("Relatório de vendas à prazo", chapterFont);
        Chapter chapter = new Chapter(new Paragraph(chunk), 1);

        Chunk chunk2 = new Chunk("Lista de clientes com venda à prazo não pagos.\n\n", chapterFont);
        Chapter chapter2 = new Chapter(new Paragraph(chunk2), 2);

        Chunk chunk3 = new Chunk("Lista de clientes com venda à prazo pagos.\n\n", chapterFont);
        Chapter chapter3 = new Chapter(new Paragraph(chunk3), 3);

        //Adicionando um paragrafo
        chapter.add(new Paragraph("Este relatório abrange todas as vendas a prazo do depósito Popular gás. "
                + "Abaixo segue a tabela ordenada da venda mais antiga para a mais recente ainda não pagos.\n", paragraphFont));

        PdfPTable tableNaoPagos = new PdfPTable(4);
        for (int aw = 0; aw < size; aw++) {

            if (aw == 0) {
                tableNaoPagos.addCell("Cliente");
                tableNaoPagos.addCell("Valor");
                tableNaoPagos.addCell("Bairro");
                tableNaoPagos.addCell("Data");
            }

            tableNaoPagos.addCell(vendas.get(aw).getCliente().getNome());
            tableNaoPagos.addCell(String.valueOf(vendas.get(aw).getValor()));
            tableNaoPagos.addCell(vendas.get(aw).getCliente().getBairro());
            tableNaoPagos.addCell(Texto.formataDataPraTabela(vendas.get(aw).getData()));

        }

        PdfPTable tablePagos = new PdfPTable(4);
        for (int aw = 0; aw < size; aw++) {

            if (aw == 0) {
                tablePagos.addCell("Cliente");
                tablePagos.addCell("Valor");
                tablePagos.addCell("Bairro");
                tablePagos.addCell("Data");
            }

            tablePagos.addCell(vendas.get(aw).getCliente().getNome());
            tablePagos.addCell(String.valueOf(vendas.get(aw).getValor()));
            tablePagos.addCell(vendas.get(aw).getCliente().getBairro());
            tablePagos.addCell(Texto.formataDataPraTabela(vendas.get(aw).getData()));

        }

        document.addTitle("Relatório de vendas à prazo " + Texto.formataDataPraTabela(new Date()));
        document.addCreator("paulosouzacbcc@gmail.com");
        document.addAuthor("Paulo Souza");
        document.addCreationDate();
        document.add(chapter);
        document.add(chapter2);
        document.add(tableNaoPagos);
        document.add(chapter3);
        document.add(tablePagos);
        document.close();
    }

}
