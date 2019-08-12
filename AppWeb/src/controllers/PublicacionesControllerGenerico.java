package controllers;

import java.io.Serializable;
import java.util.List;

import javax.ejb.EJB;
import javax.enterprise.context.Dependent;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import javax.inject.Named;
import javax.servlet.http.HttpServletRequest;

import org.primefaces.event.SelectEvent;

import com.ejb.model.Carpeta;
import com.ejb.model.Publicaciones;
import com.ejb.session.CarpetaSession;

import com.generico.session.GenericSession;

@SuppressWarnings("deprecation")
@ManagedBean(name = "publicacionesControllerGenerico")
@SessionScoped

//@Named("someBean")
//@RequestScoped
public class PublicacionesControllerGenerico implements Serializable {

	private static final long serialVersionUID = 1L;
	
	//llame o conecte con la capa de presentacion
	@EJB
	private GenericSession<Publicaciones> ejbPublicacionesSessionGenerico;
	
	//crear un obj carpeta
	public Publicaciones publicaciones;
	
	//objeto para cargar la lista de carpeta
	DataModel<Publicaciones> listarP;
	private List<Publicaciones> listaFindAll;  
	
	private int estado;
	private String mensaje;
	
	public PublicacionesControllerGenerico() {
		if (publicaciones != null) {
			publicaciones = new Publicaciones();
		}
	}
	
	

	public Publicaciones getPublicaciones() {
		return publicaciones;
	}

	public void setPublicaciones(Publicaciones publicaciones) {
		this.publicaciones = publicaciones;
	}

	//modificar el listar con el metdo listar del EJB
	//public DataModel<T> getListarC() {
	//listarC =  new ListDataModel<T>(ejbDaoGenericoSession.findAll());
		//return listarC;
	//}

	//public void setListarC(DataModel<Carpeta> listarC) {
		//this.listarC = listarC;
	//}
	
	private void loadPublicaciones() {  
    	//FacesContext context = FacesContext.getCurrentInstance();
        try {  
        	listaFindAll= (List<Publicaciones>) ejbPublicacionesSessionGenerico.findAll();  
        } catch (Exception ex) {  
           mensaje ="Error while processing getting Employees list";
        	//context.addMessage(null, new FacesMessage(mensaje.toString()));
             ex.printStackTrace();  
        }  
   }  

	public List<Publicaciones> getListaFindAll() {
		//if (listaFindAll == null) {  
            loadPublicaciones();  
       //}  
		return listaFindAll;
	}



	public void setListaFindAll(List<Publicaciones> listaFindAll) {
		this.listaFindAll = listaFindAll;
	}



	public int getEstado() {
		return estado;
	}

	public void setEstado(int estado) {
		this.estado = estado;
	}

	public String getMensaje() {
		return mensaje;
	}

	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}
	
	public void limpiar() {
		publicaciones = new Publicaciones();
		estado=0;
	}
	
	public String grabar() {
		FacesContext context = FacesContext.getCurrentInstance();
		try {
			if (getEstado()==1) {
				 ejbPublicacionesSessionGenerico.update(publicaciones);
				 mensaje="actualizado";
				context.addMessage(null, new FacesMessage(
					mensaje.toString()	));
			}
			else {
				ejbPublicacionesSessionGenerico.save(publicaciones);
				mensaje="grabado";
				context.addMessage(null, new FacesMessage(
					mensaje.toString()));
			}
		} catch (Exception e) {
			mensaje = new FacesMessage(FacesMessage.SEVERITY_ERROR, "error",
					e.toString()).toString();
		}
	return null;
	}

	
	public void buscar(ActionEvent e) throws Exception{
		publicaciones = new Publicaciones();
		publicaciones.setId(Integer.parseInt(e.getComponent().
				getAttributes().get("publicacionesbuscar").toString()));
		publicaciones = ejbPublicacionesSessionGenerico.findId(publicaciones.getId());
	
		if(publicaciones != null) {
			publicaciones.getId();
			publicaciones.getEditorial();
			setEstado(1);
		}
		
	}
	
	public void eliminar(ActionEvent e) {
		FacesContext context = FacesContext.getCurrentInstance();
		try {
			publicaciones = new Publicaciones();//obj vacio
			publicaciones.setId(Integer.parseInt(e.getComponent().
					getAttributes().get("publicacionesbuscar").toString()));			
			publicaciones = ejbPublicacionesSessionGenerico.findId(publicaciones.getId());
			ejbPublicacionesSessionGenerico.delete(publicaciones);
		mensaje="eliminado";
		context.addMessage(null, new FacesMessage(mensaje.toString()));
		
			
		} catch (Exception e2) {
			mensaje = new FacesMessage(
					FacesMessage.SEVERITY_ERROR,"error", 
					e2.toString()).toString();
			e2.printStackTrace();
		context.addMessage(null, new FacesMessage(mensaje.toString()));
		}
		
	}
	

}
