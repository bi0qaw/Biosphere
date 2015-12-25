package com.gmail.bi0qaw;

import org.bukkit.Location;
import org.bukkit.plugin.java.JavaPlugin;

import ch.njol.skript.Skript;
import ch.njol.skript.lang.ExpressionType;

public class Main extends JavaPlugin{
	public void onEnable(){
		Skript.registerAddon(this);
		//
		
		Skript.registerExpression(ExprToRad.class, Number.class, ExpressionType.PROPERTY, "%number% [in] rad[ian]");
		Skript.registerExpression(ExprToDeg.class, Number.class, ExpressionType.PROPERTY, "%number% [in] deg[ree]");
		Skript.registerExpression(ExprMidpoint.class, Location.class, ExpressionType.PROPERTY, "midpoint of %locations%");
		Skript.registerExpression(ExprLineLoc.class, Location.class, ExpressionType.SIMPLE, "linear coord[inate][s] %number% from %locations% to %location%");
		Skript.registerExpression(ExprLine.class, Location.class, ExpressionType.SIMPLE, "line[s] from %locations% to %location%[ with] density %number%");
		Skript.registerExpression(ExprLinkAll.class, Location.class, ExpressionType.SIMPLE, "[all ]%locations% (linked|connected)[ with] density %number%");
		Skript.registerExpression(ExprPolygon.class, Location.class, ExpressionType.SIMPLE, "polygon[s] at %locations% with %integer% (vertex|vertices|vertexes)(,| and) radius %number%");
		Skript.registerExpression(ExprPolygonOutline.class, Location.class, ExpressionType.SIMPLE, "polygon[s] outline[s] at %locations% with %integer% (vertex|vertices|vertexes)(,| and) radius %number%(,| and) density %number%");
		Skript.registerExpression(ExprCube.class, Location.class, ExpressionType.SIMPLE, "cube[s] at %locations%[ with] radius %number%");
		Skript.registerExpression(ExprCubeOutline.class, Location.class, ExpressionType.SIMPLE, "cube[s] outline[s] at %locations%[ with] radius %number%[ and] density %number%");
		Skript.registerExpression(ExprCylinderLoc.class, Location.class, ExpressionType.SIMPLE, "cylinder coord[inate][s][ at] %locations%[ with] coordinates %number%(,| and) %number%(,| and) %number%");
		Skript.registerExpression(ExprHelix.class, Location.class, ExpressionType.SIMPLE, "heli(x|xes|ces) at %locations% with radius %number%(,| and) height %number%(,| and) step (height|size) %number%(,| and) density %number%");
		Skript.registerExpression(ExprCircle.class, Location.class, ExpressionType.SIMPLE, "circle[s] at %locations%[ with] radius %number%(,| and) density %number%");
		Skript.registerExpression(ExprSphereLoc.class, Location.class, ExpressionType.SIMPLE, "spheric[al][ coord[inate][s][ at] %locations%[ with] coordinates %number%(,| and) %number%(,| and) %number%");
		Skript.registerExpression(ExprSphere.class, Location.class, ExpressionType.SIMPLE, "sphere[s] at %locations%[ with] radius %number%(,| and) density %number%");
		Skript.registerExpression(ExprSphereRand.class, Location.class, ExpressionType.SIMPLE, "random sphere[s] at %locations% with radius %number%(,| and) density %number%");
		Skript.registerExpression(ExprRotate.class, Location.class, ExpressionType.SIMPLE, "%locations% rotated around %location%[ in] direction %number%, %number%, %number%(,| with) angle %number%");
		Skript.registerExpression(ExprRotXYZ.class, Location.class, ExpressionType.SIMPLE, "%locations% rotated around (1¦x|2¦y|3¦z)(-| )axis[ at] %location%(,| with) angle %number%");
		Skript.registerExpression(ExprReflection.class, Location.class, ExpressionType.SIMPLE, "%locations% mirrored at %location%[ (in|with) direction %number%, %number%, %number%]");
		Skript.registerExpression(ExprScale.class, Location.class, ExpressionType.SIMPLE, "%locations% scaled[ with] center %location% by %number%[[ and] direction %number%, %number%, %number%]");
		Skript.registerExpression(ExprMove.class, Location.class, ExpressionType.SIMPLE, "(move|shift) %locations%[ with] center %location% to %location%"); 
	}
	
}
