package test;

import java.io.File;
import javax.servlet.annotation.WebServlet;
import javax.servlet.annotation.MultipartConfig;
//import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.io.*;
import javax.servlet.http.Part;
import java.util.logging.*;

@WebServlet(name = "FileUploadServlet", urlPatterns = {"/upload"})
@MultipartConfig
public class TestServlet extends HttpServlet {
    /*
    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init();

        list = FileList.getInstance();
    }*/
    private ArrayList<File> filesList; /*= FileList.getListFiles("C:\\Users\\User\\Documents\\ServletDirectory")*/
    private ArrayList<File> directoryList;
    private final static Logger LOGGER = 
            Logger.getLogger(TestServlet.class.getCanonicalName());
    
    /*protected void processRequest(HttpServletRequest request,
        HttpServletResponse response)
        throws ServletException, IOException {
    response.setContentType("text/html;charset=UTF-8");
    final String path = request.getParameter("destination");
    final Part filePart = request.getPart("file");
    final String fileName = getFileName(filePart);
}*/

private String getFileName(final Part part) {
    final String partHeader = part.getHeader("content-disposition");
    LOGGER.log(Level.INFO, "Part Header = {0}", partHeader);
    for (String content : part.getHeader("content-disposition").split(";")) {
        if (content.trim().startsWith("filename")) {
            return content.substring(
                    content.indexOf('=') + 1).trim().replace("\"", "");
        }
    }
    return null;
}
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        filesList = FileList.getListFiles("C:\\Users\\User\\Documents\\ServletDirectory");
        directoryList=FileList.getListDirectory("C:\\Users\\User\\Documents\\ServletDirectory");
        request.setAttribute("filesList", filesList);
        request.setAttribute("directoryList", directoryList);
        switch (action == null ? "info" : action) {
            
            case "info":
            default:
                response.setHeader("Cache-Control", "no-cache");
                request.getRequestDispatcher("/test.jsp").forward(request, response);
                break;
        }
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String action = request.getParameter("action");
        
        switch (action == null ? "info" : action) {
            case "createDir":
                final String pathCreateDir = request.getParameter("pathDir");
                final String directoryName = request.getParameter("directoryName");
                File fd = new File(pathCreateDir + File.separatorChar+directoryName);
                fd.mkdir();
                request.getRequestDispatcher("/createFile.jsp").forward(request, response);
                break;
            case "create":
                final String pathCreate = request.getParameter("path");
                final String fileNameCreate = request.getParameter("fileName");
                File fout = new File(pathCreate + File.separatorChar+fileNameCreate);
                fout.createNewFile();
                request.getRequestDispatcher("/createFile.jsp").forward(request, response);
                break;
            case "delete":
                final String pathDelete = request.getParameter("pathDelete");
                final String fileNameDelete = request.getParameter("fileNameDelete");
                File fdel = new File(pathDelete + File.separatorChar+fileNameDelete);
                fdel.delete();
                request.getRequestDispatcher("/delete.jsp").forward(request, response);
                break;
            case "deleteDir":
                final String pathDeleteDir = request.getParameter("pathDeleteDir");
                final String dirDelete = request.getParameter("directoryNameDelete");
                File fdd = new File(pathDeleteDir + File.separatorChar+dirDelete);
                fdd.delete();
                request.getRequestDispatcher("/delete.jsp").forward(request, response);
                break;
            case "upload":
                final String path = request.getParameter("destination");
                final Part filePart = request.getPart("file");
                final String fileName = getFileName(filePart);
                OutputStream out = null;
                InputStream filecontent = null;
                final PrintWriter writer = response.getWriter();

                try {
                    out = new FileOutputStream(new File(path + File.separator
                        + fileName));
                    filecontent = filePart.getInputStream();

                    int read = 0;
                    final byte[] bytes = new byte[1024];

                    while ((read = filecontent.read(bytes)) != -1) {
                        out.write(bytes, 0, read);
                    }
                    request.getRequestDispatcher("/update.jsp").forward(request, response);
                    //writer.println("New file " + fileName + " created at " + path);
                    LOGGER.log(Level.INFO, "File{0}being uploaded to {1}", 
                    new Object[]{fileName, path});
                    /////////////////////
                    //response.setHeader("Cache-Control", "no-cache");
                    //String redirectURL = "http://localhost:8080/TestServlet/test";
                    //response.sendRedirect(redirectURL);
                    /////////////////////
                    } catch (FileNotFoundException fne) {
                        writer.println("You either did not specify a file to upload or are "
                                + "trying to upload a file to a protected or nonexistent "
                                + "location.");
                        writer.println("<br/> ERROR: " + fne.getMessage());

                        LOGGER.log(Level.SEVERE, "Problems during file upload. Error: {0}", 
                                new Object[]{fne.getMessage()});
                    } finally {
                        if (out != null) {
                            out.close();
                        }
                        if (filecontent != null) {
                            filecontent.close();
                        }
                        if (writer != null) {
                            writer.close();
                        }
                    }
                    break;
                    case "info":
                    default:
                    //response.setHeader("Cache-Control", "no-cache");
                    //request.getRequestDispatcher("/test.jsp").forward(request, response);
                    break;
        }
    }
}