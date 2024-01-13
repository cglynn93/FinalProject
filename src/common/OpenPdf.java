/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package common;

import java.io.File;
import java.io.IOException;
import javax.swing.JOptionPane;
import java.awt.Desktop;
        /**
         *
         * @author chloeglynn
         */

public class OpenPdf {
    public static void openById(String id) {
        try {
            // Specify the file path using the correct file separator for the platform
            String filePath = "/Users/chloeglynn/Documents/" + File.separator + id + ".pdf";
            File pdfFile = new File(filePath);

            if (pdfFile.exists()) {
                // Use Desktop class to open the file with the default application
                if (Desktop.isDesktopSupported()) {
                    Desktop.getDesktop().open(pdfFile);
                } else {
                    // If Desktop is not supported, you can fallback to your previous approach
                    Process p = Runtime.getRuntime().exec("rundll32 url.dll,FileProtocolHandler " + filePath);
                }
            } else {
                JOptionPane.showMessageDialog(null, "File does not exist");
            }
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Error opening PDF: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        // Example usage
        OpenPdf.openById("");
    }
}
