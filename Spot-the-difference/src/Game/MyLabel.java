package Game;

import java.awt.AlphaComposite;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Insets;
import javax.swing.*;


class MyLabel extends JComponent //이미지를 넣고 설정한 크기에 맞춰 리사이즈 되는 Lable
{
	ImageIcon image;
	Image img;
	
	int top, left, bottom, right;

	public MyLabel(ImageIcon imageIcon, int width, int height ) {
		image = imageIcon;
		img = image.getImage();
		this.setPreferredSize(new Dimension(width, height));
	}
	
	public MyLabel(ImageIcon imageIcon, int width, int height, int top, int left, int bottom, int right ) {
		image = imageIcon;
		img = image.getImage();
		this.setPreferredSize(new Dimension(width, height));
		this.top=top;
		this.left=left;
		this.bottom=bottom;
		this.right=right;
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponents(g);
		g.drawImage(img, 0, 0, getWidth(), getHeight(),this);
		setOpaque(false);
	}
	
	public Insets getInsets() { //안쪽 여백 관련 메소드
		Insets in = new Insets(top,left,bottom,right);
		return in;
	}
	
}////////////////////////////////////////////////////////////////////////////////////////////////

class SizeButton extends JButton //이미지를 넣고 설정한 크기에 맞춰 리사이즈 되는 Button
{
	ImageIcon normalImage;
	ImageIcon rolloverImage;
	ImageIcon pressedImage;
	Image baseImg;
	Image rolloverImg;
	Image pressedImg;
	Image resetImg;
	Image tmpImg;
	Image blankImg;
	
	
	public SizeButton(ImageIcon normalImage, ImageIcon rolloverImage, ImageIcon pressedImage, int width, int height ) {
		this.setOpaque(false);
		this.setBorderPainted(false);this.setContentAreaFilled(false);this.setFocusPainted(false);
		this.normalImage = normalImage;
		this.rolloverImage = rolloverImage;
		this.pressedImage = pressedImage;
		
		this.setPreferredSize(new Dimension(width, height));
		
		baseImg = this.normalImage.getImage();
		rolloverImg = this.rolloverImage.getImage();
		pressedImg = this.pressedImage.getImage();
		resetImg = this.normalImage.getImage();
	}
	
	public void paint(Graphics g) {
		//super.paintComponents(g);
		super.paint(g);
		g.drawImage(baseImg, 0, 0, getWidth(), getHeight(),this);
		g.drawImage(tmpImg, 0, 0, getWidth(), getHeight(),this);
		setOpaque(false);
	}
}///////////////////////////////////////////////////////////////////////

class SizeButton2 extends JButton //이미지를 넣고 설정한 크기에 맞춰 리사이즈 되는 Button
{
	ImageIcon Image;
	Image img;
	
	public SizeButton2(ImageIcon Image, int width, int height ) {
		this.setOpaque(false);
		this.setBorderPainted(false);this.setContentAreaFilled(false);this.setFocusPainted(false);
		this.Image = Image;
		
		this.setPreferredSize(new Dimension(width, height));
		
		img = this.Image.getImage();
		
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponents(g);
		//super.paint(g);
		g.drawImage(img, 0, 0, getWidth(), getHeight(),this);
		setOpaque(false);
	}
}///////////////////////////////////////////////////////////////////////


class SizePanel extends JPanel{ //이미지를 넣고 설정한 크기에 맞춰 리사이즈 되는 Panel / top, left, bottom, right 값을 넣으면 안쪽 여백도 조정 가능
	
	ImageIcon image;
    Image img;
    
    int top, left, bottom, right;
    
	  public SizePanel(ImageIcon imageIcon, int width, int height){
	   image = imageIcon;
	   img = image.getImage();
	   this.setPreferredSize(new Dimension(width, height));   
	 }
	  
	  
	  public SizePanel(ImageIcon imageIcon, int width, int height, int top, int left, int bottom, int right){
		  image = imageIcon;
		  img = image.getImage();
		  this.setPreferredSize(new Dimension(width, height));   
		  this.top=top;
		  this.left=left;
		  this.bottom=bottom;
		  this.right=right;
	  }
	  
	 public void paint(Graphics g){
	  g.drawImage(img, 0, 0, getWidth(), getHeight(), this);
	  setOpaque(false);//투명하게
	  super.paint(g);   
	  }
	 
	 public Insets getInsets() { //안쪽 여백 관련 메소드
		Insets in = new Insets(top,left,bottom,right);
		return in;
	}

}//////////////////////////////////////////////////////////////////////////////////////////////

class TransparencyPanel extends JPanel{// 투명도를 조절하면서 안쪽여백을 줄수있는 Panel
	
	int top, left, bottom, right;
	float transparency;
	
	public TransparencyPanel() {//그냥 투명도 조절할수 있는 panel을 만들고 싶을때
		
	}
	
	public TransparencyPanel(int top, int left, int bottom, int right, float transparency) {//투명도를 주면서 안쪽여백을 주는 panel을 만들고 싶을때 / 안쪽여백 top, left, bottom, right값 입력 / 투명도 transparency 입력
		this.top=top;
		this.left=left;
		this.bottom=bottom;
		this.right=right;
		this.setOpaque(false);
		this.transparency=transparency;
	}
	
	public void paintComponent(Graphics g) {//투명도
		super.paintComponent(g);

		Graphics2D g2d = (Graphics2D) g.create();
		
		g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, transparency)); //transparency 값이 0.0f이면 투명 1.0f이면 불투명 (0.0 ~ 1.0 까지 조절)
		        
		g2d.setColor(getBackground());
		g2d.fill(getBounds());
		g2d.dispose();
	}
	
	public Insets getInsets() { //안쪽 여백 관련 메소드
		Insets in = new Insets(top,left,bottom,right);
		return in;
	}

}/////////////////////////////////////////////////////////////////////////////////////////////

