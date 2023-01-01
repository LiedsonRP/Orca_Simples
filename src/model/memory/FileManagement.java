/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.memory;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Classe utilitária que permite gerenciar os arquivos do sistema
 * @author lieds
 */
public class FileManagement {
    /**
     * Deleta um arquivo específico de um diretório
     * @param file_path caminho do arquivo
     */
    public static void deleteFile(String file_path) {
        try {
            Path path = Paths.get(file_path);
            Files.deleteIfExists(path);
        } catch (IOException ex) {
            Logger.getLogger(FileManagement.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println(ex.getMessage());
        }
    }
    /**
     * Verifica se um arquivo específico existe, retornando true ou false
     * @param file_path caminho do arquivo
     * @return Boolena
     */
    public static boolean checkFileExists(String file_path) {
        Path path = Paths.get(file_path);
        return Files.exists(path);
    }
    /**
     * Cria um novo arquivo num diretório especificado
     * @param file_path caminho onde o arquivo deverá ser criado     
     */
    public static void createFile(String file_path) {
        try {
            Path path = Paths.get(file_path);
            Files.createFile(path);
        } catch (IOException ex) {
            Logger.getLogger(FileManagement.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println(ex.getMessage());
        }
    }
    /**
     * Retorna uma lista contendo as linhas de um arquivo de texto
     *
     * @param file_path caminho do arquivo no sistema
     * @return List
     */
    public static List<String> readFile(String file_path) {
        try {
            Path path = Paths.get(file_path);
            List<String> file_lines = Files.readAllLines(path);
            return file_lines;
        } catch (IOException ex) {
            Logger.getLogger(FileManagement.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
}
