package Game;

import java.awt.AlphaComposite;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Insets;
import javax.swing.*;


class MyLabel extends JComponent //�̹����� �ְ� ������ ũ�⿡ ���� �������� �Ǵ� Lable
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
	
	public Insets getInsets() { //���� ���� ���� �޼ҵ�
		Insets in = new Insets(top,left,bottom,right);
		return in;
	}
	
}////////////////////////////////////////////////////////////////////////////////////////////////

class SizeButton extends JButton //�̹����� �ְ� ������ ũ�⿡ ���� �������� �Ǵ� Button
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

class SizeButton2 extends JButton //�̹����� �ְ� ������ ũ�⿡ ���� �������� �Ǵ� Button
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


class SizePanel extends JPanel{ //�̹����� �ְ� ������ ũ�⿡ ���� �������� �Ǵ� Panel / top, left, bottom, right ���� ������ ���� ���鵵 ���� ����
	
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
	  setOpaque(false);//�����ϰ�
	  super.paint(g);   
	  }
	 
	 public Insets getInsets() { //���� ���� ���� �޼ҵ�
		Insets in = new Insets(top,left,bottom,right);
		return in;
	}

}//////////////////////////////////////////////////////////////////////////////////////////////

class TransparencyPanel extends JPanel{// ������ �����ϸ鼭 ���ʿ����� �ټ��ִ� Panel
	
	int top, left, bottom, right;
	float transparency;
	
	public TransparencyPanel() {//�׳� ���� �����Ҽ� �ִ� panel�� ����� ������
		
	}
	
	public TransparencyPanel(int top, int left, int bottom, int right, float transparency) {//������ �ָ鼭 ���ʿ����� �ִ� panel�� ����� ������ / ���ʿ��� top, left, bottom, right�� �Է� / ���� transparency �Է�
		this.top=top;
		this.left=left;
		this.bottom=bottom;
		this.right=right;
		this.setOpaque(false);
		this.transparency=transparency;
	}
	
	public void paintComponent(Graphics g) {//����
		super.paintComponent(g);

		Graphics2D g2d = (Graphics2D) g.create();
		
		g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, transparency)); //transparency ���� 0.0f�̸� ���� 1.0f�̸� ������ (0.0 ~ 1.0 ���� ����)
		        
		g2d.setColor(getBackground());
		g2d.fill(getBounds());
		g2d.dispose();
	}
	
	public Insets getInsets() { //���� ���� ���� �޼ҵ�
		Insets in = new Insets(top,left,bottom,right);
		return in;
	}

}/////////////////////////////////////////////////////////////////////////////////////////////

