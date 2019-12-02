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

        <title>Edit Country</title>

        <!-- Bootstrap core CSS -->
        <link href="vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">

        <!-- Custom styles for this template -->
        <link href="css/blog-post.css" rel="stylesheet">
        <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>



    </head>

    <body>
        <script type="text/javascript">
            $(document).ready(function () {
                $("#c_val").css("color", "red");
                $("#cn_val").css("color", "red");
                $("#r_val").css("color", "red");
                $("#c_val").css('visibility', 'hidden');
                $("#cn_val").css('visibility', 'hidden');
                $("#r_val").css('visibility', 'hidden');

                $("#countryid").change(function () {
                    if (!validateFormC()) {
                        $("#c_val").css("visibility", "visible");
                    } else {
                        $("#c_val").css("visibility", "hidden");
                    }
                });
                $("#countryname").change(function () {
                    if (!validateFormCn()) {
                        $("#cn_val").css("visibility", "visible");
                    } else {
                        $("#cn_val").css("visibility", "hidden");
                    }
                });
                $("#regionid").change(function () {
                    if (!validateFormR()) {
                        $("#r_val").css("visibility", "visible");
                    } else {

                        $("#r_val").css("visibility", "hidden");

                    }
                });
            });
            function validateFormC() {
                var ucountryid = $("#countryid").val();
                if (ucountryid == "") {
                    $("#c_val").text(("* Country ID must be filled out"));
                    return false;
                } else if (ucountryid.length > 2) {
                    $("#c_val").text(("* Country Id capacity is only 2"));
                    return false;
                } else if ($.trim(ucountryid) == "") {
                    $("#c_val").text(("* Country should have an ID"));
                    return false;
                } else {
                    $("#c_val").text((""));
                    return true;
                }
            }
            function validateFormCn() {
                var uname = $("#countryname").val();
                if (uname == "") {
                    $("#cn_val").text(("* Country name must be filled out"));
                    return false;
                } else if (uname.length > 40) {
                    $("#cn_val").text(("* Country name capacity is only 40"));
                    return false;
                } else if ($.trim(uname) == "") {
                    $("#cn_val").text(("* Country should have an Name"));
                    return false;
                } else {
                    $("#cn_val").text((""));
                    return true;
                }
            }
            function validateFormR() {
                var uregionid = $("#regionid").val();
                if (uregionid < 1) {
                    $("#r_val").text(("* Region ID must be above 0"));
                    return false;
                } else {
                    $("#r_val").text((""));
                    return true;
                }
            }
        </script>
        <!-- Navigation -->
        <nav class="navbar navbar-expand-lg navbar-dark bg-dark fixed-top">
            <div class="container">
                <a class="navbar-brand" href="/HR/">HR-Main</a>
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
                    <h1 class="mt-4">Country List - Edit</h1>
                    <!-- edit form -->
                    <form method="post" name="formsave" action="controller" onsubmit="return !!(validateFormC() & validateFormCn() & validateFormR());">
                        <input type="hidden" id="id" name="id"  value="<%= request.getParameter("id")%>">
                        <input type="hidden" id="secim" name="secim" value="save">

                        <div class="form-group">
                            <label for="formGroupExampleInput">&nbsp;&nbsp; Country ID</label>
                            <input type="text" class="form-control" name="countryid" id="countryid" style="width: 300px;" value="<%= request.getParameter("countryid")%>" placeholder="Country ID">
                            <span class="" id="c_val" style="visibility: hidden" ></span>
                        </div>
                        <div class="form-group">
                            <label for="formGroupExampleInput">&nbsp;&nbsp; Country Name</label>
                            <input type="text" class="form-control" name="countryname" id="countryname" style="width: 300px;" value="<%= request.getParameter("countryname")%>" placeholder="Country Name">
                            <span class="" id="cn_val" style="visibility: hidden" ></span>
                        </div>
                        <div class="form-group">
                            <label for="formGroupExampleInput">&nbsp;&nbsp; Region ID</label>
                            <input type="number" class="form-control" name="regionid" id="regionid" style="width: 300px;" value="<%= request.getParameter("regionid")%>" placeholder="Region ID">
                            <span class="" id="r_val" style="visibility: hidden" ></span>
                        </div>
                        <a href="/HR/countries.jsp" class="btn btn-secondary">&laquo; Back</a>
                        <input type="submit" class="btn btn-success" value="Save" />
                    </form>




                    <hr>




                </div>

            </div>
            <!-- /.row -->

        </div>
        <!-- /.container -->

        <!-- Footer -->
        <footer class="py-5 bg-dark">
            <div class="container">
                <p class="m-0 text-center text-white">Copyright &copy; byMordo</p>
            </div>
            <!-- /.container -->
        </footer>

        <!-- Bootstrap core JavaScript -->
        <script src="vendor/jquery/jquery.min.js"></script>
        <script src="vendor/bootstrap/js/bootstrap.bundle.min.js"></script>
        <!--<script src="https://ajax.aspnetcdn.com/ajax/jQuery/jquery-3.4.1.min.js"></script>-->
    </body>

</html>
