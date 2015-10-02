
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link href="assets/css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
        <link href="assets/css/bootstrap-theme.min.css" rel="stylesheet" type="text/css"/>
        <link href="assets/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <div class="container">
            <div class="page-header">
                <h1>Person Excercise</h1>
            </div>
            <div class="panel panel-default">
                <div class="panel-group" id="accordion">
                    <div class="panel-heading" style="margin-left: -15px">
                        <label class="panel-title, btn btn-link">
                            <button class="btn btn-primary" id="refresh">Refresh</button>
                            <a id= "addPerson" data-toggle="collapse" class="btn btn-primary" data-parent="#accordion" 
                               href="#collapseOne">
                                add Person
                            </a>
                        </label>
                        <br>
                </div>
                    <div id="collapseOne" class="panel-collapse collapse out">
                        <div class="panel-body">
                            <div class="col-sm-8">
                                <form>
                                    <div class="col-sm-8">
                                        <input id="firstname" type = "text" placeholder="Firstname" class="form-control">
                                    </div>
                                    <div class="col-sm-8">
                                        <input id="lastname" type = "text" placeholder="Lastname" class="form-control">
                                    </div>
                                    <div class="col-sm-8">
                                        <input id="phone" type = "text" placeholder="Phone Number" class="form-control">
                                    </div>
                                    <div class="col-sm-2">
                                        <input style="float: right" id="create" type = "submit" value="Create" class="btn btn-info">
                                    </div>
                                </form>
                                <br>
                            </div>
                        </div>
                    </div>
                    <div id="collapseTwo" class="panel-collapse collapse out">
                        <div class="panel-body">
                            <div class="col-sm-8">
                                <div class="col-xs-8">
                                    <input type="text" id = "selectedId" class="form-control" disabled>
                                </div>
                                <div class="col-sm-8">
                                    <input type="text" id = "selectedFirstname" class="form-control">
                                </div>
                                <div class="col-sm-8">
                                    <input type="text" id = "selectedLastname" class="form-control">
                                </div>
                                <div class="col-sm-8">
                                    <input type="text" id = "selectedPhone" class="form-control">
                                </div>
                                <div class="col-sm-2">
                                    <input style="float: right" id="update" type="submit" class="btn btn-info" value="Update">
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                 <div class="col-sm-12">
                        <table class="table table-striped">
                            <thead>
                            <th>Firstname</th>
                            <th>Lastname</th>
                            <th>Phone</th>
                            <th></th>
                            <th></th>
                            </thead>   
                            <tbody id="tableBody">
                            </tbody>
                        </table>
                    </div>
            </div>
        </div>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
        <script src="assets/js/javascript.js" type="text/javascript"></script>
        <script src="assets/js/bootstrap.min.js" type="text/javascript"></script>
    </body>
</html>
