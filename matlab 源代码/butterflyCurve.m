clear
clc

tic;

x=0:pi/50:20*pi;
y=exp(cos(x-pi/2))-2*cos(4*(x-pi/2))+sin((x-pi/2)/12).^5;
polarplot(x,y);

toc;
