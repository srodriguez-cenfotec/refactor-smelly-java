package com.smelly.handlers;

import java.text.MessageFormat;
import java.util.Locale;
import java.util.ResourceBundle;

/**
 * Maneja operaciones básicas sobre usuarios: bienvenida, notificación y salida por consola,
 * aplicando validación centralizada para evitar duplicación.
 */
public class UserHandlerImpl implements UserHandler {

    private static final String BUNDLE_BASE_NAME = "com.smelly.handlers.messages";
    private static final String ERROR_EMPTY_USER_KEY = "error.empty.user";
    private static final String WELCOME_MESSAGE_KEY = "welcome.message";
    private static final String WELCOME_EMAIL_MESSAGE_KEY = "welcome.email.message";
    private static final String USER_PRINTED_MESSAGE_KEY = "user.printed.message";

    private final ResourceBundle messages;

    /**
     * Crea una instancia usando el locale por defecto del sistema.
     */
    public UserHandlerImpl() {
        this(Locale.getDefault());
    }

    /**
     * Crea una instancia usando el locale indicado.
     *
     * @param locale locale que determina el idioma de los mensajes
     */
    public UserHandlerImpl(Locale locale) {
        this.messages = ResourceBundle.getBundle(BUNDLE_BASE_NAME, locale);
    }

    /**
     * Procesa un usuario y muestra un mensaje de bienvenida si el nombre es válido.
     *
     * @param userName nombre del usuario a procesar
     */
    @Override
    public void process(String userName) {
        if (hasInvalidUser(userName)) {
            return;
        }

        printMessage(buildMessage(WELCOME_MESSAGE_KEY, userName));
    }

    /**
     * Envía una notificación de bienvenida al usuario si el nombre es válido.
     *
     * @param userName nombre del usuario a notificar
     */
    @Override
    public void notify(String userName) {
        if (hasInvalidUser(userName)) {
            return;
        }

        printMessage(buildMessage(WELCOME_EMAIL_MESSAGE_KEY, userName));
    }

    /**
     * Imprime información del usuario si el nombre es válido.
     *
     * @param userName nombre del usuario a imprimir
     */
    @Override
    public void print(String userName) {
        if (hasInvalidUser(userName)) {
            return;
        }

        printMessage(buildMessage(USER_PRINTED_MESSAGE_KEY, userName));
    }

    /**
     * Verifica si el usuario es inválido; en ese caso imprime el mensaje de error.
     *
     * @param userName nombre del usuario a validar
     * @return {@code true} si el usuario es inválido, {@code false} en caso contrario
     */
    private boolean hasInvalidUser(String userName) {
        if (!isValid(userName)) {
            printErrorMessage();
            return true;
        }

        return false;
    }

    /**
     * Valida que el nombre de usuario no sea nulo ni vacío.
     *
     * @param userName nombre del usuario a validar
     * @return {@code true} si el nombre es válido, {@code false} en caso contrario
     */
    private boolean isValid(String userName) {
        return userName != null && !userName.isEmpty();
    }

    /**
     * Imprime el mensaje de error de usuario inválido.
     */
    private void printErrorMessage() {
        printMessage(getMessage(ERROR_EMPTY_USER_KEY));
    }

    /**
     * Construye un mensaje localizado aplicando formato con parámetros.
     *
     * @param messageKey llave del mensaje en el bundle
     * @param userName nombre del usuario
     * @return mensaje construido
     */
    private String buildMessage(String messageKey, String userName) {
        return MessageFormat.format(getMessage(messageKey), userName);
    }

    /**
     * Obtiene un mensaje localizado desde el bundle de recursos.
     *
     * @param messageKey llave del mensaje
     * @return texto localizado
     */
    private String getMessage(String messageKey) {
        return messages.getString(messageKey);
    }

    /**
     * Imprime un mensaje en la salida estándar.
     *
     * @param message mensaje a imprimir
     */
    private void printMessage(String message) {
        System.out.println(message);
    }
}