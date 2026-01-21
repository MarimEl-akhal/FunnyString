package org.example.client;

import org.example.io.method.input.BufferReaderStrategy;
import org.example.io.method.input.InputStrategy;
import org.example.io.method.input.ScannerStrategy;
import org.example.io.method.output.OutputStrategy;
import org.example.io.method.output.PrintStanderStrategy;
import org.example.io.method.output.PrintWriterStrategy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class ServerHandler {
    private final Socket clientSocket;
    private final BufferedReader in;
    private final PrintWriter out;


    public ServerHandler(Socket socket) throws IOException {
        this.clientSocket = socket;
        this.in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream())); //input from server
        this.out = new PrintWriter(clientSocket.getOutputStream(), true); // the output that is connected to server


    }

    public void handle() throws IOException {
        Scanner sc = new Scanner(System.in);
        InputStrategy scanner = new ScannerStrategy(sc);
        InputStrategy buffer = new BufferReaderStrategy(in);
        OutputStrategy pw = new PrintWriterStrategy(out);
        OutputStrategy sys  =new PrintStanderStrategy();
        while (true) {
            String option = scanner.read().toUpperCase();
            pw.print(option);

            String log = buffer.read();
            sys.print(log);

            String run = buffer.read();
            sys.print(run);

            String finishMessage = "Strategy " + option + " is finished";
            switch (option) {
                case "FUNRANGE": {
                    String boringString = scanner.read();
                    pw.print(boringString);

                    String startIndices = scanner.read();
                    pw.print(startIndices);

                    String endIndices = scanner.read();
                    pw.print(endIndices);


                    String line;
                    while ((line = buffer.read()) != null) {
                        if (line.equals(finishMessage)) {
                            sys.print(line);
                            break;
                        }
                        sys.print(line);
                    }

                    break;
                }
                case "FUNNYSTRING": {
                    String boringString = scanner.read();
                    pw.print(boringString);

                    String startIndices = scanner.read();
                    pw.print(startIndices);

                    String endIndices = scanner.read();
                    pw.print(endIndices);

                    String operations = scanner.read();
                    pw.print(operations);

                    String line;
                    while ((line = buffer.read()) != null) {
                        if (line.equals(finishMessage)) {
                            sys.print(line);
                            break;
                        }
                        sys.print(line);
                    }

                    break;
                }

                case "GET_FUNRANGEBYID": {
                    String id = scanner.read();
                    pw.print(id);

                    String line;
                    while ((line = buffer.read()) != null) {
                        if (line.equals(finishMessage)) {
                            sys.print(line);
                            break;
                        }
                        sys.print(line);
                    }

                    break;
                }


            }
        }

    }
}
