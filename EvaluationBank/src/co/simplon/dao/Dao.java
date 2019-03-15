package co.simplon.dao;
import java.sql.Connection;

/** 
 * Application de gestion bancaire, partie DAO
 * @version 1.0
 * @author El babili
 */

public abstract class Dao<T> {

	public Connection connection = BankConnection.getConnection();
	
	/**
	 * Permet de récupérer un objet via son ID
	 * @param id
	 * @return T
	 */
	public abstract T find(int id);
	
	/**
	 * Permet de créer une entrée dans la base de données
	 * par rapport à un objet
	 * @param obj
	 * @return boolean
	 */
	public abstract boolean create(T obj);
	
	/**
	 * Permet de mettre à jour les données d'une entrée dans la base 
	 * @param obj
	 * @return boolean
	 */
	public abstract boolean update(T obj);
	
	/**
	 * Permet la suppression d'une entrée de la base
	 * @param obj
	 * @return boolean
	 */
	public abstract boolean delete(T obj);
}
	
	
	