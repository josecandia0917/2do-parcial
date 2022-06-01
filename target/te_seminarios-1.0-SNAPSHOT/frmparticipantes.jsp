
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!doctype html>
<html lang="es">
    <head>
        <!-- Required meta tags -->
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.1.1/css/all.min.css" rel="stylesheet">
        <!-- Bootstrap CSS -->
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">

        <title> Nuevo </title>
    </head>
    <body>
        <div class="container">
            <h1>Formulario de participantes </h1>
            <jsp:include page="META-INF/menu.jsp"> 
                <jsp:param name="opcion" value="participantes" />
            </jsp:include>
            <br>
            <form action="ParticipantesControlador" method="post">
                <input type="hidden" name="id" value="${participantes.id}">
                <div class="mb-3">
                    <label for="" class="form-label">Apellidos</label>
                    <input type="text" class="form-control" name="nombre" value="${participantes.apellidos}" placeholder="Escriba su apellidos">
                    
                </div>
                 <div class="mb-3">
                    <label for="" class="form-label">Nombres</label>
                    <input type="text" class="form-control" name="descripcion" value="${participantes.nombres}" placeholder="Escriba su nombre">
                    
                </div>
                <div class="mb-3">
                    <label for="" class="form-label">Id_seminadio</label>
                    <input type="text" class="form-control" name="precio" value="${participantes.id_seminario}" placeholder="Escriba el id del seminario">
                    
                </div>
                    <div class="mb-3">
                    <label for="" class="form-label">Confirmado</label>
                    <input type="text" class="form-control" name="precio" value="${participantes.confirmado}" placeholder="Escriba su confirmacion">
                    
                </div>
                <button type="submit" class="btn btn-primary">Enviar</button>

            </form>
        </div>

        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>


    </body>
</html>
