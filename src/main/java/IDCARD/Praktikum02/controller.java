/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package IDCARD.Praktikum02;


import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author Belinda merlansyah
 */
@Controller
public class controller {
    @RequestMapping("/Projectidcard")
    
    public String Projectidcard (@RequestParam ("Name") String text,
                                 @RequestParam ("NIM") String nomer,
                                 @RequestParam ("Tanggal") @DateTimeFormat(pattern = "yyyy-MM-dd")Date date,
                                 @RequestParam ("image") MultipartFile file, Model Model,
                                 @RequestParam ("jurusan") String jurusan)
                                 throws IOException {
        
        SimpleDateFormat Tanggal = new SimpleDateFormat("EEEE, YYY-MM-dd");
        
        String newTanggal = Tanggal.format(date);
        
        String blob = Base64.encodeBase64String(file.getBytes());
                
        String gambar = "data:image/jpeg;base64,".concat(blob);
        
        Model.addAttribute("Nm", text);
        Model.addAttribute("tgl", newTanggal);
        Model.addAttribute("gmbr", gambar);
        Model.addAttribute("nomer", nomer);
        Model.addAttribute("jurusann", jurusan);
        
        
        return "card";
    }
    
}
