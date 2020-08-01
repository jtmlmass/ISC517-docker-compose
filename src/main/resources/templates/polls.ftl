<div id="layoutSidenav_content">
    <main>
        <div class="container-fluid">
            <h1 class="mt-4">${mainHeader}</h1>
            <ol class="breadcrumb mb-4">
                <li class="breadcrumb-item active">${pathHeader}</li>
            </ol>
            <div class="row">
                <div class="col">
                    <div class="card">
                        <div class="card-header">
                            <i class="fas fa-pie-chart mr-1"></i>Graphs
                        </div>
                        <div class="card-body">
                            <!--Div that will hold the pie chart-->
                            <div id="columnchart_material" style="width: 800px; height: 500px;"></div>
                        </div>
                    </div>
                </div>
            </div>
            <br />
            <div class="row">
                <div class="col">
                    <div class="card mb-4">
                        <div class="card-header"><i class="fas fa-table mr-1"></i>Results Data Table</div>
                        <div class="card-body">
                            <div class="table-responsive">
                                <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
                                    <thead>
                                    <tr>
                                        <th>¿Las charlas donde usted participó cumplieron con sus expectativas?</th>
                                        <th>¿Los expositores mostraron tener dominio del tema?</th>
                                        <th>¿Las instalaciones del evento fueron comfortables para usted?</th>
                                        <th>¿Las charlas donde usted participó cumplieron con sus expectativas?</th>
                                        <th>User</th>
                                    </tr>
                                    </thead>
                                    <tfoot>
                                    <tr>
                                        <th>¿Las charlas donde usted participó cumplieron con sus expectativas?</th>
                                        <th>¿Los expositores mostraron tener dominio del tema?</th>
                                        <th>¿Las instalaciones del evento fueron comfortables para usted?</th>
                                        <th>¿Las charlas donde usted participó cumplieron con sus expectativas?</th>
                                        <th>User</th>
                                    </tr>
                                    </tfoot>
                                    <tbody>
                                    <#list polls as poll>
                                        <tr>
                                            <td>${poll.answer1}</td>
                                            <td>${poll.answer2}</td>
                                            <td>${poll.answer3}</td>
                                            <td>${poll.answer4}</td>
                                            <td>${poll.user.username}</td>
                                        </tr>
                                    </#list>
                                    </tbody>
                                </table>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </main>
    <footer class="py-4 bg-light mt-auto">
        <div class="container-fluid">
            <div class="d-flex align-items-center justify-content-between small">
                <div class="text-muted">${copyRight}</div>
                <div>
                    <a href="#">Privacy Policy</a>
                    &middot;
                    <a href="#">Terms &amp; Conditions</a>
                </div>
            </div>
        </div>
    </footer>
</div>
<!--Load the AJAX API-->  <script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>
<script type="text/javascript">
    google.charts.load('current', {'packages':['bar']});
    google.charts.setOnLoadCallback(drawChart);

    function drawChart() {
        var data = google.visualization.arrayToDataTable([
            ['Answers', 'Option 1', 'Option 2', 'Option 3', 'Option 4', 'Option 5'],
            ['Question 1', ${question11}, ${question12}, ${question13}, ${question14}, ${question15}],
            ['Question 2', ${question21}, ${question22}, ${question23}, ${question24}, ${question25}],
            ['Question 3', ${question31}, ${question32}, ${question33}, ${question34}, ${question35}],
            ['Question 4', ${question41}, ${question42}, ${question43}, ${question44}, ${question45}]
        ]);

        var options = {
            chart: {
                title: 'Barcamp Performance',
                subtitle: 'Performance trough questions in Polls',
            }
        };

        var chart = new google.charts.Bar(document.getElementById('columnchart_material'));

        chart.draw(data, google.charts.Bar.convertOptions(options));
    }
</script>

