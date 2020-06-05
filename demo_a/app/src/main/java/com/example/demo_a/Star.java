package com.example.demo_a;


import java.util.Random;

//Bây giờ chúng tôi sẽ thêm các ngôi sao nền để làm cho hình nền trông hoạt hình.
public class Star {
    private int x;
    private int y;
    private int speed;

    private int maxX;
    private int maxY;
    private int minX;
    private int minY;

    public Star(int screenX, int screenY) {
        maxX = screenX;
        maxY = screenY;
        minX = 0;
        minY = 0;
        Random generator = new Random();
        speed = generator.nextInt(10);

//        tạo tọa độ ngẫu nhiên
//        giữ tọa dộ sao cho vẫn ở trong màn hình
        x = generator.nextInt(maxX);
        y = generator.nextInt(maxY);
    }

    public void update(int playerSpeed) {
        //hình ngôi sao chuyển động theo chiêu ngang bên tría
        //bằng cách giảm x do tác đọng của người đùng
        x -= playerSpeed;
        x -= speed;
        //nếu ngooid sao chạm vào màn hình bên trái
        if (x < 0) {
            //hình ngôi sao bắt đầu lại từ bên phải
            //chuyển động này liên tục
            x = maxX;
            Random generator = new Random();
            y = generator.nextInt(maxY);
            speed = generator.nextInt(15);
        }
    }
    public float getStarWidth() {
//      random vị trí cảu các hình ngôi sao
        float minX = 1.0f;
        float maxX = 4.0f;
        Random rand = new Random();
        float finalX = rand.nextFloat() * (maxX - minX) + minX;
        return finalX;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}
