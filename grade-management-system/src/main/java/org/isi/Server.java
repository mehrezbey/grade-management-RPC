package org.isi;

import org.apache.xmlrpc.XmlRpcException;
import org.apache.xmlrpc.server.PropertyHandlerMapping;
import org.apache.xmlrpc.server.XmlRpcServer;
import org.apache.xmlrpc.webserver.WebServer;
import org.isi.impl.GradeServiceImpl;

import java.io.IOException;

public class Server {
    public static void main(String[] args) throws XmlRpcException, IOException {
        WebServer webServer = new WebServer(8081);
// Instanciation d'un serveur web sur le port 8081
        XmlRpcServer xmlRpcServer = webServer.getXmlRpcServer();
// Récupération de l'instance de serveur XML-RPC à partir du serveur web
        PropertyHandlerMapping phm = new PropertyHandlerMapping();
// Création d'un gestionnaire de mappage des méthodes/services
        phm.addHandler("Grade", GradeServiceImpl.class);

// Ajout d'un service "HelloWorld" lié à l'implémentation HelloServiceImpl
        xmlRpcServer.setHandlerMapping(phm);
// Configuration du serveur XML-RPC avec le gestionnaire de mappage
        webServer.start(); // Démarrage du serveur web
        System.out.println("Server is running...");
        System.setProperty("org.apache.xmlrpc.debug", "true");

    }
}
