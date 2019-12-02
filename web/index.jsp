<%-- 
    Document   : login
    Created on : Nov 26, 2019, 12:05:25 AM
    Author     : Mubariz
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

    <head>

        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <meta name="description" content="">
        <meta name="author" content="">

        <title>HR-Main</title>

        <!-- Bootstrap core CSS -->
        <link href="vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">

        <!-- Custom styles for this template -->
        <link href="css/blog-post.css" rel="stylesheet">

    </head>

    <body>
        <!-- Navigation -->
        <nav class="navbar navbar-expand-lg navbar-dark bg-dark fixed-top">
            <div class="container">
                <a class="navbar-brand" href="/HR" >HR-Main</a>
                <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarResponsive" aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation">
                    <span class="navbar-toggler-icon"></span>
                </button>
                <div class="collapse navbar-collapse" id="navbarResponsive">
                    <ul class="navbar-nav ml-auto">
                        <li class="nav-item">
                            <a class="nav-link" href="/HR/countries.jsp">Countries
                            </a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="/HR/employees.jsp">Employees</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="#">Services</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="#" data-toggle="modal" data-target="#exampleModal">Contact</a>
                        </li>
                    </ul>
                    <form class="form-inline my-2 my-lg-0">

                        <input class="form-control mr-sm-2" type="text" placeholder="Search" aria-label="Search">
                        <button class="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button>
                    </form>
                </div>
            </div>
        </nav>
        <main role="main">

            <!-- Main jumbotron for a primary marketing message or call to action -->
            <div class="jumbotron">
                <div class="container">
                    <h1 class="display-3">Welcome!</h1>
                    <p>This Project is just for me to improve my Web Skills. Every day i learn something and try to use here. You can click on Countries to see Country-List. You can Edit and Delete them. Click on Employees to see Employee-List. You can click on every Employee too see more info about them.</p>
                    <!--<p><a class="btn btn-primary btn-lg" href="3" role="button">See more »</a></p>-->
                </div>
            </div>

            <div class="container">
                <!-- Example row of columns -->
                <div class="row">
                    <div class="col-md-4">
                        <h2>Never</h2>
                        <p>“The computer was born to solve problems that did not exist before.”<em>— Bill Gates<br>&nbsp; </em></p>
                        <p><a class="btn btn-secondary" href="https://de.wikipedia.org/wiki/Bill_Gates" target="_blank" role="button">View details »</a></p>
                    </div>
                    <div class="col-md-4">
                        <h2>Give</h2>
                        <p>“I think the things you regret most in life are the things you didn’t do.”<em>— Steve Jobs<br>&nbsp; </em></p>
                        <p><a class="btn btn-secondary" href="https://de.wikipedia.org/wiki/Steve_Jobs" target="_blank" role="button">View details »</a></p>
                    </div>
                    <div class="col-md-4">
                        <h2>Up</h2>
                        <p>"Sometimes it is the people no one can imagine anything of who do the things no one can imagine."<em>— Alan Turing<br>&nbsp; </em></p>
                        <p><a class="btn btn-secondary" href="https://de.wikipedia.org/wiki/Alan_Turing" target="_blank" role="button">View details »</a></p>
                    </div>
                </div>

                <hr>

            </div> <!-- /container -->

        </main>
        <form method="post" action="">
            <div class="modal fade" id="exampleModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
                <div class="modal-dialog" role="document">
                    <div class="modal-content">
                        <div class="modal-header">
                            <h5 class="modal-title" id="exampleModalLabel">Contact</h5>
                            <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                <span aria-hidden="true">&times;</span>
                            </button>
                        </div>
                        <div class="modal-body">
                            <ul>
                                <li>Telefon: +49 178 3077621</li>
                                <li>Email: mubariz.azim.09@gmail.com</li>
                            </ul> 
                        </div>
                        <div class="modal-footer">
                            <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
                            <a class="btn btn-info" href="https://www.linkedin.com/in/mubariz-azimov-2b2581197/" target="_blank" role="button">Linkedin »</a>          
                        </div>
                    </div>
                </div>
            </div>
        </form>
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