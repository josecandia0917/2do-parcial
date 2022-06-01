<%
    String opcion = request.getParameter("opcion");
%>    
            <ul class="nav nav-tabs">
                <li class="nav-item">
                    <a class="nav-link <%= (opcion.equals("productos") ? "active" : "")%>"  href="ParticipantesControlador">Participantes</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link <%= (opcion.equals("clientes") ? "active" : "")%>"" href="SeminariosControlador">Seminarios</a>
                </li>             
            </ul>  