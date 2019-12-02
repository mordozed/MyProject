<%-- 
    Document   : index
    Created on : Nov 9, 2019, 5:12:09 PM
    Author     : Mubariz
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="com.task.entities.Countries"%>
<%@page import="java.util.List"%>
<%@page import="com.task.DAO.CountryImp"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="com.task.DAO.CountryService"%>

<!DOCTYPE html>
<html lang="en">

    <head>

        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <meta name="description" content="">
        <meta name="author" content="">

        <title>HR-Countries</title>

        <!-- Bootstrap core CSS -->
        <link href="vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">

        <!-- Custom styles for this template -->
        <link href="css/blog-post.css" rel="stylesheet">

    </head>

    <body>
        <script type="text/javascript">
            function Demo(id) {
                $("#qwerty").val(id);
            }
        </script>

        <!-- Navigation -->
        <nav class="navbar navbar-expand-lg navbar-dark bg-dark fixed-top">
            <div class="container">
                <a class="navbar-brand" href="/HR" >HR-Main</a>
                <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarResponsive" aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation">
                    <span class="navbar-toggler-icon"></span>
                </button>
                <div class="collapse navbar-collapse" id="navbarResponsive">
                    <ul class="navbar-nav ml-auto">
                        <li class="nav-item active">
                            <a class="nav-link" href="/HR/countries.jsp">Countries
                                <span class="sr-only">(current)</span>
                            </a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="/HR/employees.jsp">Employees</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="#">Services</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="#">Contact</a>
                        </li>
                    </ul>
                </div>
            </div>
        </nav>

        <!-- Page Content -->
        <div class="container">

            <div class="row">

                <!-- Post Content Column -->
                <div class="col-lg-8">

                    <!-- Title -->
                    <h1 class="mt-4">Country List</h1>

                    <!-- Preview Image -->
                    <table class="table table-bordered table-hover">
                        <thead>
                            <tr>
                                <th scope="col">ID</th> 
                                <th scope="col">Country ID</th>
                                <th scope="col">Country Name</th>
                                <th colspan="2" scope="col">Region ID</th>
                            </tr>
                        </thead>
                        <tbody>
                            <%
                                CountryImp ci = new CountryService();
                                List<Countries> cntr = new ArrayList<Countries>(ci.getAllCountries());
                                for (Countries c : cntr) {
                            %>

                        <input type="hidden" name="secim" value="delete">
                        <input type="hidden"  class="s" name="idd"  value="<%= c.getId()%>">
                        <tr>
                            <td class="idd"><a href="controller?id=<%= c.getId()%>&countryid=<%= c.getCountryId()%>&countryname=<%= c.getName()%>&regionid=<%= c.getRegionId()%>&secim=edit" style="display:block;"><%= c.getId()%></a></td>
                            <td><a href="controller?id=<%= c.getId()%>&countryid=<%= c.getCountryId()%>&countryname=<%= c.getName()%>&regionid=<%= c.getRegionId()%>&secim=edit" style="display:block;"><%= c.getCountryId()%></a></td>
                            <td><a href="controller?id=<%= c.getId()%>&countryid=<%= c.getCountryId()%>&countryname=<%= c.getName()%>&regionid=<%= c.getRegionId()%>&secim=edit" style="display:block;"><%= c.getName()%></a></td>
                            <td><a href="controller?id=<%= c.getId()%>&countryid=<%= c.getCountryId()%>&countryname=<%= c.getName()%>&regionid=<%= c.getRegionId()%>&secim=edit" style="display:block;"><%= c.getRegionId()%></a></td>

                            <td><button type="button" id="delete" onclick="Demo(<%= c.getId()%>)" class="btn btn-danger" data-toggle="modal" data-target="#exampleModal">Delete</button></td>
                        </tr>



                        <%
                            }
                        %>
                        </tbody>
                    </table>
                    <hr>
                </div>
            </div>
        </div>
        <!--bootstrap starts-->
        <form method="post" action="controller">
            <div class="modal fade" id="exampleModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
                <div class="modal-dialog" role="document">
                    <div class="modal-content">
                        <div class="modal-header">
                            <h5 class="modal-title" id="exampleModalLabel">Warning!</h5>
                            <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                <span aria-hidden="true">&times;</span>
                            </button>
                        </div>
                        <div class="modal-body">
                            Are you sure to delete? 
                            <input type="hidden" name="id" id="qwerty"/>
                            <input type="hidden" name="secim" value="delete">
                        </div>
                        <div class="modal-footer">
                            <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
                            <input type="submit"  class="btn btn-danger" value="Delete" />
                        </div>
                    </div>
                </div>
            </div>
        </form>
        <!--bootstrap ends-->
        <!-- Footer -->
        <footer class="py-5 bg-dark">
            <div class="container">
                <p class="m-0 text-center text-white">Copyright &copy; byMordo</p>
            </div>
        </footer>
        <!-- Bootstrap core JavaScript -->
        <script src="vendor/jquery/jquery.min.js"></script>
        <script src="vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

    </body>

</html>
