package org.isi;

import org.apache.xmlrpc.XmlRpcException;
import org.apache.xmlrpc.client.XmlRpcClient;
import org.apache.xmlrpc.client.XmlRpcClientConfigImpl;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;

public class Client {

    public static void main(String[] args) throws MalformedURLException, XmlRpcException {
        // Configuration du client XML-RPC avec l'URL du serveur
        XmlRpcClientConfigImpl config = new XmlRpcClientConfigImpl();
        config.setServerURL(new URL("http://localhost:8081/xmlrpc"));
        // Création du client XML-RPC
        XmlRpcClient client = new XmlRpcClient();
        client.setConfig(config);

        // Scanner to read user input

        Scanner scanner = new Scanner(System.in);

        // Menu for the user
        System.out.println("Choose an operation:");
        System.out.println("1 - Add 2 Grades");
        System.out.println("2 - Multiply 2 Grades");
        System.out.println("3 - Subtract 2 Grades");
        System.out.println("4 - Divide 2 Grades");
        System.out.println("5 - Insert Grade");
        System.out.println("6 - Delete Grade");
        System.out.println("7 - Edit Grade");
        System.out.println("8 - Display All Grades");
        System.out.println("9 - Exit");
        System.setProperty("org.apache.xmlrpc.debug", "true");



        int choice = 1;
        while (choice>0) {

            choice = scanner.nextInt();
            if(choice<5){
                System.out.print("Enter first  number: ");
                double a = scanner.nextDouble();
                System.out.print("Enter Second  number: ");
                double b = scanner.nextDouble();

                double result = 0;


                switch (choice) {
                    case 1:
                        result = (double) client.execute("Grade.add", new
                                Object[]{a, b});
                        System.out.println("Sum: " + result);
                        break;

                    case 2:
                        result = (double) client.execute("Grade.multiply", new
                                Object[]{a, b});
                        System.out.println("Product: " + result);
                        break;

                    case 3:
                        result = (double) client.execute("Grade.subtract", new
                                Object[]{a, b});
                        System.out.println("Subtract : " + result);
                        break;

                    case 4:
                        result = (double) client.execute("Grade.divide", new
                                Object[]{a, b});
                        System.out.println("Division : " + result);
                        break;
                }
            }
            else if( choice<8){
                System.out.print("Enter the student's full name: ");
                String name = scanner.next();


                switch (choice) {

                    case 5:

                        System.out.print("Enter their  grade: ");
                        double grade = scanner.nextDouble();

                        System.out.println(client.execute("Grade.insert", new
                                Object[]{name, grade}));
                        break;

                    case 6:

                        System.out.println(client.execute("Grade.delete", new
                                Object[]{name}));
                        break;

                    case 7:
                        System.out.print("Enter their new  grade: ");
                        double newGrade = scanner.nextDouble();
                        System.out.println(client.execute("Grade.edit", new
                                Object[]{name, newGrade}));
                        break;
                }
            }
            else if(choice == 8){
                System.out.println(client.execute("Grade.all", new Object[]{}));
            }
            else if(choice == 9){
                break;
            }
        }

        scanner.close();


    }
}