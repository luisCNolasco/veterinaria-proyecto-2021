package com.veterinaria.repository;

import java.util.List;
import com.veterinaria.entity.Interfaz;
import com.veterinaria.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import org.springframework.data.repository.query.Param;

	
public interface UsuarioRepository extends JpaRepository<Usuario,Integer> {

    @Query("select e from Usuario e where e.dni_usu = :#{#usu.dni_usu} and e.pass_usu = :#{#usu.pass_usu}")
    public abstract Usuario iniciarSesion(@Param(value = "usu") Usuario bean);
    
    /*@Query("Select i from Interfaz i, TipoUsuarioHasInterfaz ti, TipoUsuario tu, UsuarioHasTipoUsuario uu where "
    		 + " i.cod_Int = ti.interfaz.cod_Int and " 
    		 + " ti.tipoUsuario.cod_Tip_Usu = tu.cod_Tip_Usu and " 
    		 + " tu.cod_Tip_Usu = uu.tipoUsuario.cod_Tip_Usu and " 
    		 + " uu.usuario.cod_Usu = :var_cod_Usu")
	public abstract List<Interfaz> traerInterfazDeUsuario(@Param("var_cod_Usu") int cod_Usu);


    @Query("Select tu from TipoUsuario tu, UsuarioHasTipoUsuario u where "
			+ " tu.cod_Tip_Usu = u.tipoUsuario.cod_Tip_Usu and "
			+ " u.usuario.cod_Usu = :var_cod_Usu")
	public abstract List<TipoUsuario> traerTipoDeUsuario(@Param("var_cod_Usu") int cod_Usu);*/
    
    @Query("select i from Interfaz i where i.cod_tip_usu = :cod_tip_usu")
	public abstract List<Interfaz> traerInterfazDeUsuario(@Param("cod_tip_usu") int cod_tip_usu);
    
    
}