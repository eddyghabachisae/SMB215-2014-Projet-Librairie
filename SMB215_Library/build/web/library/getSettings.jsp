<%-- 
    Document   : getSettings
    Created on : Sep 24, 2014, 7:45:29 PM
    Author     : eddy
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@page import="library.Library"%>
<%@page import="library.LibraryBean"%>

<% 
    LibraryBean libBean = new LibraryBean();
    Library lib = new Library();
    libBean.getLibrary(lib);
    
    session.setAttribute("name", lib.getName());
    session.setAttribute("mainBranch", lib.getMainBranch());
    session.setAttribute("website", lib.getWebsite());
    session.setAttribute("rentalDays", lib.getRentalDays());
    session.setAttribute("reservationDays", lib.getReservationDays());
    session.setAttribute("maxReserve", lib.getMaxReserve());
    session.setAttribute("rentalAlert", lib.getRentalAlert());
    session.setAttribute("reservationAlert", lib.getReservationAlert());
    session.setAttribute("mainCurrency", lib.getMainCurrency());
    session.setAttribute("secondaryCurrency", lib.getSecondaryCurrency());
    session.setAttribute("secondaryCurrencyRate", lib.getSecondaryCurrencyRate());
    
    response.sendRedirect("../home.jsp");
 %>