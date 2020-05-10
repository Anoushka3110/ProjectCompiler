/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class NewServlet extends HttpServlet {
    
    static String  result="", error="",test="67";
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException{
        response.setContentType("text/html;charset=UTF-8");
        if(!"".equals(request.getParameter("codeArea"))){ 
            String code=request.getParameter("codeArea");
            String language=request.getParameter("language");
            if(!"".equals(request.getParameter("custom"))){
                test=request.getParameter("inputArea");
                request.setAttribute("input","Showing Result for Custom Input:\n"+test);
            }
            else
                request.setAttribute("input","Showing Result for Test Case:\n"+test);
            request.setAttribute("code",code);
            compile(language,code,test);
            request.setAttribute("res",result+error);
            result="";
            error="";
        }
        else
            request.setAttribute("res","Try Typing Something......");    
            request.getRequestDispatcher("index.jsp").forward(request, response);
        }
        
    protected void compile(String language, String code,String input){
        try {
            File f;
            BufferedWriter bw;
            switch(language){
                case "c/cpp":
                    f=new File("Hello.cpp");
                    bw=new BufferedWriter(new FileWriter(f));
                    bw.write(code);
                    bw.close();

                    Run("g++ Hello.cpp -o Hello.exe","");
                    Run("Hello.exe", input);
         
                    
                    break;
                    
                case "java":
                    f=new File("Main.java");
                    bw=new BufferedWriter(new FileWriter(f));
                    bw.write(code);
                    bw.close();

                    Run("javac Main.java","");
                    Run("java Main", input);
                    
                    break;
                    
                case "python":
                    f=new File("hello.py");
                    bw=new BufferedWriter(new FileWriter(f));
                    bw.write(code);
                    bw.close();

                    Run("python hello.py", input);
                   
                    break;
                    
            }
        } catch (IOException | InterruptedException ex) {
            Logger.getLogger(NewServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
	}
    
	public static void Run(String command, String input) throws IOException, InterruptedException {
            // create process
            String[] argss = {"cmd", "/c", command};
            ProcessBuilder pb = new ProcessBuilder(argss);
            Process process = pb.start();        

            // create writer and reader
            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(process.getOutputStream())); 
            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            BufferedReader eReader = new BufferedReader(new InputStreamReader(process.getErrorStream()));

            // write input
            if(!"".equals(input))
            writer.write(input+"\n");
            writer.flush();
            

            // read output
            String line="";
            while ((line = reader.readLine()) != null) {
            result+=line+"\n";
            }

            // read error
            line="";
            while ((line = eReader.readLine()) != null) {
            error+=line+"\n";
            }

            // close writer reader
            reader.close();
            writer.close();
        }
	
    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
