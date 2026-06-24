package com.smelly.handlers;

/**
 * Define el contrato para manejar operaciones de usuario.
 */
public interface UserHandler {

    /**
     * Procesa un usuario.
     *
     * @param userName nombre del usuario
     */
    void process(String userName);

    /**
     * Notifica a un usuario.
     *
     * @param userName nombre del usuario
     */
    void notify(String userName);

    /**
     * Imprime información de un usuario.
     *
     * @param userName nombre del usuario
     */
    void print(String userName);
}