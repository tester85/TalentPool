package acl.information.professional.infrastructure.model;


import java.util.Date;
import java.util.List;


public class PerfilRequest {
    String professionalId;
    String nombre;
    String apellidos;
    String correo;
    String telefono;
    String fechaNacimiento;
    List<String> nacionalidad;
    String paisResidencia;
    String ciudad;
    String comuna;
    String carreraTi;
    //    casa de estudios
    String semestre;
    String horario;
    String universidad;
    String fechaEgreso;
    String estado;
    Boolean esPractica;
    //    Competencias
    List<String> lenguajesProgramacion;
    List<String> frameworks;
    List<String> idiomas;
    List<String> basesDatos;

    //
    public PerfilRequest(String professionalId, String nombre, String apellidos, String telefono, String fechaNacimiento, String correo, List<String> nacionalidad, String paisResidencia, String ciudad, String comuna, String carreraTi, String semestre, String horario, String estado, Boolean esPractica, List<String> lenguajesProgramacion, List<String> frameworks, List<String> idiomas, List<String> basesDatos) {
        this.professionalId = "";
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.telefono = telefono;
        this.correo = correo;
        this.fechaNacimiento = fechaNacimiento;
        this.nacionalidad = nacionalidad;
        this.paisResidencia = paisResidencia;
        this.ciudad = ciudad;
        this.comuna = comuna;
        this.carreraTi = carreraTi;
        this.semestre = semestre;
        this.horario = horario;
        this.estado = estado;
        this.esPractica = esPractica;
        this.lenguajesProgramacion = lenguajesProgramacion;
        this.frameworks = frameworks;
        this.idiomas = idiomas;
        this.basesDatos = basesDatos;
    }

    public PerfilRequest() {

    }

    public String getProfessionalId() {
        return professionalId;
    }

    public String getNombre() {
        return nombre;
    }

    public String getFechaNacimiento() {
        return fechaNacimiento;
    }

    public String getUniversidad() {
        return universidad;
    }

    public String getFechaEgreso() {
        return fechaEgreso;
    }

    public String getApellidos() {
        return apellidos;
    }

    public String getTelefono() {
        return telefono;
    }

    public String getCorreo() {
        return correo;
    }

    public List<String> getNacionalidad() {
        return nacionalidad;
    }

    public String getPaisResidencia() {
        return paisResidencia;
    }

    public String getCiudad() {
        return ciudad;
    }

    public String getComuna() {
        return comuna;
    }

    public String getCarreraTi() {
        return carreraTi;
    }

    public String getSemestre() {
        return semestre;
    }

    public String getHorario() {
        return horario;
    }

    public String getEstado() {
        return estado;
    }

    public Boolean getEsPractica() {
        return esPractica;
    }

    public List<String> getLenguajesProgramacion() {
        return lenguajesProgramacion;
    }

    public List<String> getFrameworks() {
        return frameworks;
    }

    public List<String> getIdiomas() {
        return idiomas;
    }

    public List<String> getBasesDatos() {
        return basesDatos;
    }

    public void setProfessionalId(String professionalId) {
        this.professionalId = professionalId;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public void setFechaNacimiento(String fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public void setNacionalidad(List<String> nacionalidad) {
        this.nacionalidad = nacionalidad;
    }

    public void setPaisResidencia(String paisResidencia) {
        this.paisResidencia = paisResidencia;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public void setComuna(String comuna) {
        this.comuna = comuna;
    }

    public void setCarreraTi(String carreraTi) {
        this.carreraTi = carreraTi;
    }

    public void setSemestre(String semestre) {
        this.semestre = semestre;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }

    public void setUniversidad(String universidad) {
        this.universidad = universidad;
    }

    public void setFechaEgreso(String fechaEgreso) {
        this.fechaEgreso = fechaEgreso;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public void setEsPractica(Boolean esPractica) {
        this.esPractica = esPractica;
    }

    public void setLenguajesProgramacion(List<String> lenguajesProgramacion) {
        this.lenguajesProgramacion = lenguajesProgramacion;
    }

    public void setFrameworks(List<String> frameworks) {
        this.frameworks = frameworks;
    }

    public void setIdiomas(List<String> idiomas) {
        this.idiomas = idiomas;
    }

    public void setBasesDatos(List<String> basesDatos) {
        this.basesDatos = basesDatos;
    }
}

