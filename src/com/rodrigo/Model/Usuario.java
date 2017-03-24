package com.rodrigo.Model;

import java.util.Date;

public class Usuario {

    private int idUsuario;
    private String primeiroNome;
    private String ultimoNome;
    private Date data;
    private String email;
	
    
	/**
	 * @return the idUsuario
	 */
	public int getIdUsuario() {
		return idUsuario;
	}


	/**
	 * @param idUsuario the idUsuario to set
	 */
	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}


	/**
	 * @return the primeiroNome
	 */
	public String getPrimeiroNome() {
		return primeiroNome;
	}


	/**
	 * @param primeiroNome the primeiroNome to set
	 */
	public void setPrimeiroNome(String primeiroNome) {
		this.primeiroNome = primeiroNome;
	}


	/**
	 * @return the ultimoNome
	 */
	public String getUltimoNome() {
		return ultimoNome;
	}


	/**
	 * @param ultimoNome the ultimoNome to set
	 */
	public void setUltimoNome(String ultimoNome) {
		this.ultimoNome = ultimoNome;
	}


	/**
	 * @return the data
	 */
	public Date getData() {
		return data;
	}


	/**
	 * @param data the data to set
	 */
	public void setData(Date data) {
		this.data = data;
	}


	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}


	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}


	@Override
	public String toString() {
        return "User [idUsuario=" + idUsuario + ", primeiroNome=" + primeiroNome
                + ", ultimoNome=" + ultimoNome + ", data=" + data + ", email="
                + email + "]";
    }    

}