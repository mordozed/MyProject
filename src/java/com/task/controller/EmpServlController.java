/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.task.controller;

import com.task.entities.Employees;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Mubariz
 */
@WebServlet(name = "empservlet", urlPatterns = {"/empservlet"})
public class EmpServlController extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        String eid = request.getParameter("id");
        String ename = request.getParameter("name");
        String esurname = request.getParameter("surname");
        String eemail = request.getParameter("email");
        String ephoneNumber = request.getParameter("phoneNumber");
        String esalary = request.getParameter("salary");
        String ecomPct = request.getParameter("comPct");
        String edepName = request.getParameter("depName");
        String estrAdd = request.getParameter("strAdd");
        String ezip = request.getParameter("zip");
        String ecity = request.getParameter("city");
        String estate = request.getParameter("state");
        String ejobTitle = request.getParameter("jobTitle");
        String eminSalary = request.getParameter("minSalary");
        String emaxSalary = request.getParameter("maxSalary");
        String ecountryName = request.getParameter("countryName");
        String eregionName = request.getParameter("regionName");

        Employees emp = new Employees();

        emp.setId(Integer.parseInt(eid));
        emp.setName(ename);
        emp.setSurname(esurname);
        emp.setEmail(eemail);
        emp.setPhoneNumber(ephoneNumber);
        emp.setSalary(esalary);
        emp.setComPct(ecomPct);
        emp.setDepName(edepName);
        emp.setStrAdd(estrAdd);
        emp.setZip(ezip);
        emp.setCity(ecity);
        emp.setState(estate);
        emp.setJobTitle(ejobTitle);
        emp.setMinSalary(eminSalary);
        emp.setMaxSalary(emaxSalary);
        emp.setCountryName(ecountryName);
        emp.setRegionName(eregionName);

        RequestDispatcher rd = request.getRequestDispatcher("/employee_i.jsp");
        rd.forward(request, response);

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
