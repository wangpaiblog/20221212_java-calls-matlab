clear
clc

tic;

t=pi:pi/100:1000*pi;
c=100;
x=c*cos(t)./t;
y=c*sin(t)./t;
plot(x,y);
axis equal;

toc;