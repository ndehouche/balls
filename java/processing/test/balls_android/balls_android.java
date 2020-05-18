package processing.test.balls_android;

import processing.core.*; 
import processing.data.*; 
import processing.event.*; 
import processing.opengl.*; 

import processing.sound.*; 

import java.util.HashMap; 
import java.util.ArrayList; 
import java.io.File; 
import java.io.BufferedReader; 
import java.io.PrintWriter; 
import java.io.InputStream; 
import java.io.OutputStream; 
import java.io.IOException; 

public class balls_android extends PApplet {



PVector location1;  // Location of shape
PVector velocity1;  // Velocity of shape
PVector gravity1;   // Gravity acts at the shape's acceleration
PVector location2;  // Location of shape
PVector velocity2;  // Velocity of shape
PVector gravity2;   // Gravity acts at the shape's acceleration
PVector speed;  // Speed of enemies
  

AudioSample sample;
  
  int numStars = 200;
float xPos[] = new float [numStars];
float yPos[] = new float [numStars];
float xSpeed[] = new float [numStars];
float ySpeed[] = new float [numStars];


 int i=0;
  int k=0;
  float j=0;
float y,x;

PFont johnFont;







Particle [] pickles = new Particle [100];
Eat [] eats = new Eat [100];
boolean gameover = false; 
boolean first=true;
int a; 
int score=0;




class Enemy {
  int c,d;
  int x, y;
  float speed;
  boolean col;
  String name;
  
  Enemy(String name, boolean col) {
    this.name = name;
    c = color(0xff03F9FF);
    d =color(0xffFF0346);
     
  }
  
  public void draw() {
    
    if (col ==true){
   
  stroke(c);}
    else {
     stroke(d);}
   noFill();
   strokeWeight(1.5f);
   ellipse(x, y, .027f*width, .027f*width);
    
   
    textAlign(CENTER, TOP);
    textSize(0);
    text(name, x, y);
  }
}

ArrayList<Enemy> enemies = new ArrayList<Enemy>();
public void addEnemy(int x, int y, float speed, boolean col, String name) {
  Enemy enemy = new Enemy(name, col);
  enemy.x = x;
  enemy.y = y;
   enemy.speed = speed;
   enemy.col=col;
  enemies.add(enemy);
}

public void drawEnemies() {
 for(Enemy e: enemies) {
    e.draw();
  }
}

public void setup() {

  background(0);
  
  noStroke();
  
  frameRate(60);
  
  // Load a soundfile from the data folder of the sketch and play it back 
 // Load a soundfile from the /data folder of the sketch and play it back 
 orientation(PORTRAIT);
 
// size(320, 600);
y = .94f*height;
x = displayWidth/5;

  i=PApplet.parseInt(random(10,PApplet.parseInt(width)));
  j=random(1,5);
  
  
 for (int i = 20; i < numStars; i += random(10000,100000)) {
    fill(255);
    ellipse(random(width), random(height), 14, 14);
    
    //xPos[i] = int(random(0, width));
    //yPos[i] = int(random(0,height));
    //xSpeed[i] = random(-1,1);
    //ySpeed[i] = random(-1,1);
 }
  

 johnFont = loadFont("OpenSans-Extrabold-90.vlw");
textFont(johnFont);
 
 addEnemy(i, PApplet.parseInt(-.1f*height), j, false, "");
   i=PApplet.parseInt(random(10,PApplet.parseInt(width)));
  j=random(1,5);
  
 addEnemy(i, PApplet.parseInt(-.1f*height), j,false, "");
  i=PApplet.parseInt(random(10,PApplet.parseInt(width)));
 j=random(1,5);
  
 addEnemy(i, PApplet.parseInt(-.1f*height), j, false,"");
 i=PApplet.parseInt(random(10,PApplet.parseInt(width)));
 j=random(1,5);
  
 addEnemy(i, PApplet.parseInt(-.1f*height), j, false,"");
   i=PApplet.parseInt(random(10,PApplet.parseInt(width)));
  j=random(1,5);
  
 addEnemy(i, PApplet.parseInt(-.1f*height), j, true,"");
 i=PApplet.parseInt(random(10,PApplet.parseInt(width)));
 j=random(1,5);
  
 addEnemy(i, PApplet.parseInt(-.1f*height), j, true,"");
 i=PApplet.parseInt(random(10,PApplet.parseInt(width)));
 j=random(1,5);
  
 addEnemy(i, PApplet.parseInt(-.1f*height), j, true,"");
   i=PApplet.parseInt(random(10,PApplet.parseInt(width)));
 j=random(1,5);
  
 addEnemy(i, PApplet.parseInt(-.1f*height), j, true,"");

  
  i=PApplet.parseInt(random(10,PApplet.parseInt(width)));
 j=random(1,5);
  
 addEnemy(i, PApplet.parseInt(-.1f*height), j, false,"");
   i=PApplet.parseInt(random(10,PApplet.parseInt(width)));
 j=random(1,5);
  
 addEnemy(i, PApplet.parseInt(-.1f*height), j, true,"");
   i=PApplet.parseInt(random(10,PApplet.parseInt(width)));
 j=random(1,5);
  
 addEnemy(i, PApplet.parseInt(-.1f*height), j, false,"");
   i=PApplet.parseInt(random(10,PApplet.parseInt(width)));
 j=random(1,5);
  
 addEnemy(i, PApplet.parseInt(-.1f*height), j, true,"");

 
  location1 = new PVector(PApplet.parseInt(random(100,120)),100);
  velocity1 = new PVector(3.5f,5.1f);
  gravity1 = new PVector(0,0.3f);
  location2 = new PVector(PApplet.parseInt(random(10,30)),150);
  velocity2 = new PVector(3.5f,5.1f);
  gravity2 = new PVector(0,0.3f);
a=0;


for (int i=0; i<pickles.length; i++) {
   pickles [i] = new Particle ();
 }
 

 
 
}

public void draw() {
background(51);
 
fill(0, 3);
  rect(0, 0, width, height);
  
   

  
 if (first){
   filter(ERODE);
 fill(0xffE5EED3);
 textSize(80);
    
     textSize(.03f*width);
    textAlign(CENTER);
   text("Click to play",width/2,1.2f*height/2);
     textSize(.02f*width);
    textAlign(CENTER);
  text("Created by Nassim Dehouche on April 18th-20th 2020.",width/2,.8f*height); 
  
  
   textFont(johnFont);
   textAlign(CENTER);
   textSize(.2f*width);
     text("BALLS",width/2,height/2);
    if (mousePressed)
 {
  
  first=false;
  score=0;
  
}
 
 
 }
 
 else{

 

 stroke(255);

strokeWeight(2);  // Thicker
 if (gameover==false){
 fill(0xffE5EED3);
 textAlign(LEFT);
   textSize(.03f*width);
   text("Score: " +score,34,.03f*height);
  }
   for (int i = 50; i < numStars; i += random(10000,100000)) {
    fill(255);
    ellipse(random(width), random(height), 14, 14);}
 drawEnemies();
enemies.get(0).y+=enemies.get(0).speed;
enemies.get(1).y+=enemies.get(1).speed;
enemies.get(2).y+=enemies.get(2).speed;
enemies.get(3).y+=enemies.get(3).speed;
enemies.get(4).y+=enemies.get(4).speed;
enemies.get(5).y+=enemies.get(5).speed;
enemies.get(6).y+=enemies.get(6).speed;
enemies.get(7).y+=enemies.get(7).speed;
enemies.get(8).y+=enemies.get(8).speed;
enemies.get(9).y+=enemies.get(9).speed;
enemies.get(10).y+=enemies.get(10).speed;
enemies.get(11).y+=enemies.get(11).speed;

for (int k=0; k< enemies.size(); k++) {
PVector v = new PVector(enemies.get(k).x, enemies.get(k).y);
PVector distanceVect0 = PVector.sub(location1, v);
float distanceVectMag0 = distanceVect0.mag();

// Minimum distance before they are touching
    float minDistance0 = .02f*width;

    if (distanceVectMag0 < minDistance0 && enemies.get(k).col==true) {
   
  
  
   enemies.get(k).y=-20;
  enemies.get(k).x=PApplet.parseInt(random(10,490));
  score+=1;
      }
}

for (int k=0; k< enemies.size(); k++) {
PVector v = new PVector(enemies.get(k).x, enemies.get(k).y);
PVector distanceVect0 = PVector.sub(location2, v);
float distanceVectMag0 = distanceVect0.mag();

// Minimum distance before they are touching
    float minDistance0 = .02f*width;

    if (distanceVectMag0 < minDistance0 && enemies.get(k).col==false) {

       
    
   enemies.get(k).y=-20;
  enemies.get(k).x=PApplet.parseInt(random(10,490));
    score+=1;
      }
}



 

    // Racket
    if (mousePressed) {
    if (mouseX < x+ .12f*width) {
       x -= 10; // Left
    } else 
     if (mouseX >= x + .12f*width) {
    
       x += 10; // Right
      
    }
     }
  
   stroke(255);
  strokeWeight(2);
  fill(255);
  rect(x, y, .3f*width, 15);
    
  
  
  // Add velocity to the location.
  location1.add(velocity1);
  // Add gravity to velocity
  velocity1.add(gravity1);
   location2.add(velocity2);
  // Add gravity to velocity
  velocity2.add(gravity2);
  // Bounce off edges
  if ((location1.x > width) || (location1.x < 0)) {
    velocity1.x = velocity1.x * -1;

  }
    if ((location2.x > width) || (location2.x < 0)) {
    velocity2.x = velocity2.x * -1;

  }
  if ((location1.y > y) &&  (location1.x >= x) &&  (location1.x <= x+.3f*width)  && (gameover==false) ) {

    // We're reducing velocity ever so slightly 
    // when it hits the bottom of the window
    velocity1.y = velocity1.y * -0.99f; 
    location1.y = y;
  }else if ((location1.y > height) ) {
    // We're reducing velocity ever so slightly 
    // when it hits the bottom of the window
    velocity1.y = 0 ;
    velocity1.x = 0 ;
    location1.y = height+100;
   gameover=true;
  }
  
  
if ((location2.y > y) &&  (location2.x >= x) &&  (location2.x <= x+.3f*width) && (gameover==false) ) {
    // We're reducing velocity ever so slightly 
    // when it hits the bottom of the window

    velocity2.y = velocity2.y * -0.99f; 
    location2.y = y;
  }else if ((location2.y > height) ) {
    // We're reducing velocity ever so slightly 
    // when it hits the bottom of the window
 

    location2.y = height+100;
    velocity2.x=0;
    velocity2.y=0;
    gameover=true;

      
  }
  
  if (x<=2)  {
  x=0;
  }
  
   if (x>=width-.3f*width-4)  {
  x=width-.3f*width-4;
  }
  
  
    for (int i=0; i< enemies.size(); i++) {
 if (enemies.get(i).y >height +10){
 
 enemies.get(i).y=0;
 k=PApplet.parseInt(random(10,PApplet.parseInt(width)));
  enemies.get(i).x=k;
 }
   }
  
  
// Get distances between the balls components
PVector distanceVect = PVector.sub(location1, location2);
float distanceVectMag = distanceVect.mag();

// Minimum distance before they are touching
    float minDistance =  .02f*width;

    if (distanceVectMag < minDistance) {


       for (int i=0; i<pickles.length; i++) {
        pickles[i].x = location2.x;
    pickles[i].y = location1.y;
  pickles[i].update();
   }
      }









  // Display circle at location vector

   strokeWeight(0.3f);
    line(location1.x,location1.y,location2.x,location2.y);
    
  strokeWeight(0);
 colorMode(HSB, width, 100, 100, 100);
  noStroke();
 
  fill(0xff03F9FF);
  ellipse(location1.x,location1.y,.027f*width,.027f*width);
  
  
  fill(0xffFF0346);
  
   ellipse(location2.x,location2.y,.027f*width,.027f*width);
     
 

 if (gameover==true){
 
   filter(ERODE);
 fill(0xffE5EED3);
  textSize(.03f*width);
   textAlign(CENTER);
   text("Game Over\n Your Score: " +score,width/2,.8f*height/2);
     textAlign(CENTER);
   text("Click to play again",width/2,1.2f*height/2);

 }

   if (mousePressed && gameover==true)
 {
  
  gameover=false;
  score=0;
  setup();
}



}
}   


class Particle {
 
  float x;
  float y;
  
  float velX; // speed or velocity
  float velY;
  
  
  Particle () {
   //x and y position to be in middle of screen
  
    
    velX = random (10,50);
    velY = random (10,50);
  }
  
  public void update () {
    
    x+=velX;
    y+=velY;
    
    fill (255);
    ellipse (x,y,.01f*width,.01f*width);
  }
}


class Eat {
 
  float x;
  float y;
  
  float velX; // speed or velocity
  float velY;
  
  
  Eat () {
   //x and y position to be in middle of screen
  
    
     velX = random (-10,40);
    velY = random (-10,40);
  }
  
  public void update () {
    
      velX = random (-10,40);
    velY = random (-10,40);
    
    
    fill (0xff03F9FF);
    ellipse (x,y,.027f*width,.027f*width);
  }
}
  public void settings() {  fullScreen();  smooth(); }
}
