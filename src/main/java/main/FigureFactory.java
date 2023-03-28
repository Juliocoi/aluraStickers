package main;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
public class FigureFactory {
  public void prodution(InputStream inputStream, String archiveName) throws IOException {

//    InputStream inputStream = new FileInputStream(new File("./assets/topMovies_1.jpg"));
//    InputStream inputStream = new URL("https://uploads.jovemnerd.com.br/wp-content/uploads/2023/03/avatar_2_plataformas_digitais__0obk0j-1210x544.jpg").openStream();
    BufferedImage originalImg = ImageIO.read(inputStream);
    int widthImg = originalImg.getWidth();
    int heightImg = originalImg.getHeight();

    int newHeightImg = heightImg + 200;

    // cria uma nova img, vazia, com um fundo transparente.
    BufferedImage newImage = new BufferedImage(widthImg, newHeightImg, BufferedImage.TRANSLUCENT);
    // copiar a img original para a nova img. O gráfico abaixo é gerado com base na nova img.
    Graphics2D graphics = (Graphics2D) newImage.getGraphics();
    graphics.drawImage(originalImg, 0, 0, null );

    Font font = new Font(Font.SANS_SERIF, Font.BOLD, 64);
    graphics.setColor(Color.yellow);
    graphics.setFont(font);

    //escreve uma frase na img.
    graphics.drawString("É massa2!", 200, (newHeightImg - 100));

    // cria o arquivo com a nova imagem.
    ImageIO.write(newImage, "png",new File("./assets/output/" + archiveName));
  }
}
