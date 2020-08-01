<div id="layoutSidenav_content">
    <main>
        <div class="container-fluid">
            <h1 class="mt-4">${mainHeader}</h1>
            <ol class="breadcrumb mb-4">
                <li class="breadcrumb-item active">${pathHeader}</li>
            </ol>
            <div class="card mb-4">
                <div class="card-header"><i class="fas fa-table mr-1"></i>Poll</div>
                <div class="card-body">
                    <form action="/polls/create" method="post">
                        <#if pollsNumber gt 0>
                            <div class="row">
                                <div class="col">
                                    <div class="alert alert-success" role="alert">
                                        Ya ha llenado su formulario con exito!
                                    </div>
                                </div>
                            </div>
                        <#else>
                            <div class = row>
                                <div class="col">
                                    <div class="form-group">
                                        <label for="answer1">¿Las charlas donde usted participó cumplieron con sus expectativas?</label>
                                        <select class="form-control" id="answer1" name="answer1" required>
                                            <option>1</option>
                                            <option>2</option>
                                            <option>3</option>
                                            <option>4</option>
                                            <option selected>5</option>
                                        </select>
                                    </div>
                                </div>
                            </div>
                            <div class = row>
                                <div class="col">
                                    <div class="form-group">
                                        <label for="answer2">¿Los expositores mostraron tener dominio del tema?</label>
                                        <select class="form-control" id="answer2" name="answer2" required>
                                            <option>1</option>
                                            <option>2</option>
                                            <option>3</option>
                                            <option>4</option>
                                            <option selected>5</option>
                                        </select>
                                    </div>
                                </div>
                            </div>
                            <div class = row>
                                <div class="col">
                                    <div class="form-group">
                                        <label for="pregunta3">¿Las instalaciones del evento fueron comfortables para usted?</label>
                                        <select class="form-control" id="pregunta3" name="answer3" required>
                                            <option>1</option>
                                            <option>2</option>
                                            <option>3</option>
                                            <option>4</option>
                                            <option selected>5</option>
                                        </select>
                                    </div>
                                </div>
                            </div>
                            <div class = row>
                                <div class="col">
                                    <div class="form-group">
                                        <label for="answer4">¿Las charlas donde usted participó cumplieron con sus expectativas?</label>
                                        <select class="form-control" id="answer4" name="answer4" required>
                                            <option>1</option>
                                            <option>2</option>
                                            <option>3</option>
                                            <option>4</option>
                                            <option selected>5</option>
                                        </select>
                                    </div>
                                </div>
                            </div>
                            <div class="row justify-content-start">
                                <div class="col col-1">
                                    <a><button class="btn btn-success" type="submit">Salvar</button></a>
                                </div>
                                <div class="col col-1">
                                    <a><button class="btn btn-dark" onclick="limpiarForm()">limpiar</button></a>
                                </div>
                            </div>
                        </#if>

                    </form>
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