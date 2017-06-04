/**
 * Created by Andersony96 on 6/1/2017.
 */
import freemarker.template.Configuration;
import spark.ModelAndView;
import spark.template.freemarker.FreeMarkerEngine;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import static spark.Spark.*;


public class Main {

    static ArrayList<Estudiante> listaEstudiante = new ArrayList<Estudiante>();
    static Estudiante Anderson = new Estudiante(20130260, "Anderson", "Carrasco", "829-340-8624");
    static int i=0;

    public static void main(String[] args) {

        Configuration configuration = new Configuration(Configuration.VERSION_2_3_23);
        configuration.setClassForTemplateLoading(Main.class, "/templates");
        FreeMarkerEngine freeMarkerEngine = new FreeMarkerEngine(configuration);

        get("/inicio", (req, res) -> {
            Map<String, Object> attributes = new HashMap<>();
            attributes.put("titulo", "Inicio");
            attributes.put("listaEstudiante", listaEstudiante);
            return new ModelAndView(attributes, "inicio.ftl");
        },freeMarkerEngine);

        get("/registrarEstudiante", (req, res) -> {
            Map<String, Object> attributes = new HashMap<>();
            attributes.put("titulo", "Registro de Estudiante");
            return new ModelAndView(attributes, "registrarEstudiante.ftl");
        }, freeMarkerEngine);

        post("/creandoEstuadiante/", (request, response) -> {

            int matricula = Integer.parseInt(request.queryParams("matricula"));
            String nombre =request.queryParams("nombre");
            String apellido =request.queryParams("apellido");
            String telefono =request.queryParams("telefono");

            Estudiante estudianteNuevo= new Estudiante(matricula, nombre, apellido,telefono);
            listaEstudiante.add(estudianteNuevo);
            Map<String, Object> attributes = new HashMap<>();
            attributes.put("titulo", "Inicio");
            attributes.put("estudiante", estudianteNuevo);
            return new ModelAndView(attributes, "estudianteProcesado.ftl");
        }, freeMarkerEngine);

        post("/verEstudiante/:matricula", (request, response) -> {
            int matriculaObtenida = Integer.parseInt(request.params("matricula"));
            Estudiante estudianteViejo = buscarEstudiante(matriculaObtenida);
            Map<String, Object> attributes = new HashMap<>();
            attributes.put("titulo", "Estudiante Creado");
            attributes.put("estudiante", estudianteViejo);
            return new ModelAndView(attributes, "estudianteProcesado.ftl");
        }, freeMarkerEngine);


        post("/estudianteEliminado/:matricula", (request, response) -> {
            int matriculaObtenida = Integer.parseInt(request.params("matricula"));
            eliminarEstudiante(matriculaObtenida);
            Map<String, Object> attributes = new HashMap<>();
            attributes.put("titulo", "Inicio");
            attributes.put("listaEstudiante", listaEstudiante);
            return new ModelAndView(attributes, "inicio.ftl");
        }, freeMarkerEngine);

        post("/modificarEstudiante/:matricula", (request, response) -> {
            int matriculaObtenida = Integer.parseInt(request.params("matricula"));
            //System.out.println(matriculaObtenida);
            int i = posicionEstudiante(buscarEstudiante(matriculaObtenida));

            Map<String, Object> attributes = new HashMap<>();
            attributes.put("titulo", "Modificacion de Estudiante");
            attributes.put("posicion",i);
            return new ModelAndView(attributes, "modificarEstudiante.ftl");
        }, freeMarkerEngine);

        post("/ModificacionEstudiante/:posicion", (request, response) -> {
            int posicion = Integer.parseInt(request.params("posicion"));

            int matricula = Integer.parseInt(request.queryParams("matricula"));
            String nombre =request.queryParams("nombre");
            String apellido =request.queryParams("apellido");
            String telefono =request.queryParams("telefono");

            listaEstudiante.get(posicion).setMatricula(matricula);
            listaEstudiante.get(posicion).setNombre(nombre);
            listaEstudiante.get(posicion).setApellido(apellido);
            listaEstudiante.get(posicion).setTelefono(telefono);

            Map<String, Object> attributes = new HashMap<>();
            attributes.put("titulo", "Inicio");
            attributes.put("estudiante", listaEstudiante.get(posicion));
            return new ModelAndView(attributes, "estudianteProcesado.ftl");
        }, freeMarkerEngine);


    }

    ///////////////////////Funciones//////////////////////////

    public static void eliminarEstudiante(int matricula) {
        for (Estudiante estu : listaEstudiante) {
            if (estu.getMatricula() == matricula) {
                listaEstudiante.remove(estu);
            }
        }
    }

    public static Estudiante buscarEstudiante(int matricula) {
        for (Estudiante estudianteMat : listaEstudiante) {
            if (estudianteMat.getMatricula() == matricula) {
                return estudianteMat;
            }
        }
        return null;
    }

    public static int posicionEstudiante(Estudiante estu){
        for (Estudiante estudiante:listaEstudiante){
            if(listaEstudiante.get(i).getMatricula()==estu.getMatricula()){
                return i;
            }else{
                i++;
            }
        }
        return Integer.parseInt(null);
    }
}

