package com.gmail.bi0qaw;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

import org.bukkit.Location;
import org.bukkit.util.Vector;


public class TrigLib {

    public Number[] llen(Location[] l){
    	Number[] nums = new Number[Array.getLength(l)];
    	int i = 0;
    	for(Location tempLoc : l){
    		nums[i] = tempLoc.clone().toVector().length();
    		i++;
    	}
    	return nums;
    }

    public Location[] lneg(Location[] l){
    	Location[] locs = new Location[Array.getLength(l)];
    	int i = 0;
    	for(Location tempLoc : l){
    		locs[i] = tempLoc.clone().multiply(-1);
    		i++;
    	}
       return locs;
    }

    public Location[] offset(Location[] l, Location l2){
    	Location[] locs = new Location[Array.getLength(l)];
    	Vector vect = l2.clone().toVector();
    	int i = 0;
    	for(Location tempLoc : l){
    		locs[i] = tempLoc.clone().add(vect);
    		i++;
    	}
        return locs;
    }

    public Location[] coffset(Location[] l, double x, double y, double z){
    	Location[] locs = new Location[Array.getLength(l)];
    	int i = 0;
    	for(Location tempLoc : l){
    		locs[i] = tempLoc.clone().add(x, y, z);
    		i++;
    	}
        return locs;
    }

    public Location[] mult(Location[] l, double p){
    	Location[] locs = new Location[Array.getLength(l)];
    	int i = 0;
    	for(Location tempLoc : l){
    		locs[i] = tempLoc.clone().multiply(p);
    		i++;
    	}
        return locs;
    }
    public Location[] lmult(Location[] l, Location l2){
    	Location[] locs = new Location[Array.getLength(l)];
    	Vector vect = l2.clone().toVector();
    	int i = 0;
    	for(Location tempLoc : l){
    		locs[i] = tempLoc.clone().toVector().multiply(vect).toLocation(tempLoc.getWorld());
    		i++;
    	}
    	return locs;
    }

    public Location[] lnorm(Location[] l){
    	Location[] locs = new Location[Array.getLength(l)];
    	int i = 0;
    	for(Location tempLoc : l){
    		locs[i] = tempLoc.clone().toVector().normalize().toLocation(tempLoc.getWorld());
    		i++;
    	}
        return locs;
    }

    public Location[] relloc(Location[] l, Location l2){
    	Location[] locs = new Location[Array.getLength(l)];
    	Vector vect = l2.clone().toVector();
    	int i = 0;
    	for(Location tempLoc : l){
    		locs[i] = tempLoc.clone().subtract(vect);
    		i++;
    	}
    	return locs;
    }

    public Number[] dotp(Location[] l, Location l2){
    	Number[] nums = new Number[Array.getLength(l)];
    	Vector vect = l2.clone().toVector();
    	int i = 0;
    	for(Location tempLoc : l){
    		nums[i] = tempLoc.clone().toVector().dot(vect);
    		i++;
    	}
        return nums;
    }

    public Number[] cdotp(Location[] l, double x, double y, double z){
    	Number[] nums = new Number[Array.getLength(l)];
    	Vector vect = new Vector(x, y, z);
    	int i = 0;
    	for(Location tempLoc : l){
    		nums[i] = tempLoc.clone().toVector().dot(vect);
    		i++;
    	}
        return nums;
    }

    public Location[] crossp(Location[] l, Location l2){
    	Location[] locs = new Location[Array.getLength(l)];
    	Vector vect = l2.clone().toVector();
    	int i = 0;
    	for(Location tempLoc : l){
    		locs[i] = tempLoc.clone().toVector().crossProduct(vect).toLocation(tempLoc.getWorld());
    		i++;
    	}
    	return locs;
    }

    public Location[] ccrossp(Location[] l, double x, double y, double z){
    	Location[] locs = new Location[Array.getLength(l)];
    	Vector vect = new Vector(x, y, z);
    	int i = 0;
    	for(Location tempLoc : l){
    		locs[i] = tempLoc.clone().toVector().crossProduct(vect).toLocation(tempLoc.getWorld());
    		i++;
    	}
    	return locs;
    }

    public Location[] rot(Location[] l, Location center, Location direction, double phi){
    	Vector centerVect = center.clone().toVector();
    	Location[] locs = new Location[Array.getLength(l)];
    	Location lnormValue = lnorm(new Location[]{direction})[0];
    	double n1 = lnormValue.getX();
        double n2 = lnormValue.getY();
        double n3 = lnormValue.getZ();
        double x;
        double y;
        double z;
    	int i = 0;
    	for(Location tempLoc : l){
    		locs[i] = tempLoc.clone().subtract(centerVect);
    		x = locs[i].getX();
            y = locs[i].getY();
            z = locs[i].getZ();
    		locs[i].setX(x * (Math.pow(n1, 2) * ( 1 - Math.cos(phi)) + Math.cos(phi)) + y * (n2 * n1 * ( 1 - Math.cos(phi)) - n3 * Math.sin(phi)) + z * (n1 * n3 * ( 1-Math.cos(phi)) + n2 * (Math.sin(phi))) );
    	    locs[i].setY(x * (n1 * n2 * ( 1 - Math.cos(phi)) + n3 * Math.sin(phi)) + y * (Math.pow(n2, 2) * (1-Math.cos(phi))+Math.cos(phi)+z*(n2*n3*(1-Math.cos(phi))-n1*Math.sin(phi))));
    	    locs[i].setZ(x * (n3*n1* (1-Math.cos(phi))-n2*Math.sin(phi))+y*(n3*n2* ( 1 - Math.cos(phi))+n1*Math.sin(phi))+ z* (Math.pow(n3,2) * (1-Math.cos(phi)) + Math.cos(phi)));
    	    i++;
    	}
    	return offset(locs,center);
    }

    public Location[] xrot(Location[] l, Location center, double phi){
    	Vector centerVect = center.clone().toVector();
    	Location[] locs = new Location[Array.getLength(l)];
    	double y;
    	double z;
    	int i = 0;
    	for(Location tempLoc : l){
    		locs[i] = tempLoc.clone().subtract(centerVect);
    		y = locs[i].getY();
    		z = locs[i].getZ();
    		locs[i].setY(y * Math.cos(phi) + z * Math.sin(phi));
            locs[i].setZ(-y * Math.sin(phi) + z * Math.cos(phi));	
            i++;
    	}
        return offset(locs,center);
    }

    public Location[] yrot(Location[] l, Location center, double phi){
    	Vector centerVect = center.clone().toVector();
    	Location[] locs = new Location[Array.getLength(l)];
    	double x;
    	double z;
    	int i = 0;
    	for(Location tempLoc : l){
    		locs[i] = tempLoc.clone().subtract(centerVect);
    		x = locs[i].getX();
    		z = locs[i].getZ();
    		locs[i].setX(x * Math.cos(phi) - z * Math.sin(phi));
            locs[i].setZ(x * Math.sin(phi) + z * Math.cos(phi));
            locs[i].add(center);
            i++;
    	}
        return locs;
    }
    
    public Location[] zrot(Location[] l, Location center, double phi){
    	Vector centerVect = center.clone().toVector();
    	Location[] locs = new Location[Array.getLength(l)];
    	double x;
    	double y;
    	int i = 0;
    	for(Location tempLoc : l){
    		locs[i] = tempLoc.clone().subtract(centerVect);
    		x = locs[i].getX();
    		y = locs[i].getY();
    		locs[i].setX(x * Math.cos(phi) + y * Math.sin(phi));
            locs[i].setY(-x * Math.sin(phi) + y * Math.cos(phi));
            i++;
    	}
        return offset(locs,center);
    }

    public Location[] ptrefl(Location[] l, Location l2){
    	Vector vect = l2.clone().toVector();
    	Location[] locs = new Location[Array.getLength(l)];
    	int i = 0;
    	for(Location tempLoc : l){
    		locs[i] = tempLoc.clone().subtract(vect).multiply(-2).add(vect);
    		i++;
    	}
    	return locs;
    }

    public Location[] refl(Location[] l, Location point, Location dir){
    	Location[] locs = new Location[Array.getLength(l)];
    	Vector vect = point.clone().toVector().multiply(dir.clone().toVector());
    	int i = 0;
    	for(Location tempLoc : l){
    		locs[i] = tempLoc.clone().toVector().multiply(vect).toLocation(tempLoc.getWorld());
    		i++;
    	}
    	return locs;		
    }

    public Location[] scale(Location[] l, Location center, double d){
    	Vector centerVect = center.clone().toVector();
    	Location[] locs = new Location[Array.getLength(l)];
    	int i = 0;
    	for(Location tempLoc : l){
    		locs[i] = tempLoc.clone().subtract(centerVect).multiply(d).add(centerVect);
    		i++;
    	}
    	return locs;
    }
    
    public Location[] dirscale(Location[] l, Location center, Location dir, double d){
    	Vector dirv = dir.clone().toVector().normalize().multiply(d);
    	Location[] locs = new Location[Array.getLength(l)];
    	int i = 0;
    	for(Location tempLoc : l){
    		locs[i] = tempLoc.clone().subtract(center).toVector().multiply(dirv).toLocation(tempLoc.getWorld());
    		i++;
    	}
    	return locs;			
    }
    
    public Location[] cdirscale(Location[] l, Location center, double x, double y, double z){
    	Vector centerVect = center.clone().toVector();
    	Location[] locs = new Location[Array.getLength(l)];
    	Vector vect = new Vector(x, y ,z);
    	int i = 0;
    	for(Location tempLoc : l){
    		locs[i] = tempLoc.clone().subtract(centerVect).toVector().multiply(vect).toLocation(tempLoc.getWorld()).add(centerVect);
    		i++;
    	}
    	return locs;
    }
    
    public Location[] midpt(Location[] l){
    	Location loc = new Location(l[0].getWorld(), 0, 0, 0);
    	for(Location tempLoc : l){
    		loc.add(tempLoc);
    	}
    	return new Location[]{loc.multiply(1D / Array.getLength(l))};
    }
    
    public Location[] sphloc(Location[] l, double phi, double the, double r){
    	Location[] locs = new Location[Array.getLength(l)];
    	int i = 0;
    	for(Location tempLoc : l){
    		locs[i] = tempLoc.clone();
    		locs[i].setX(tempLoc.getX() + r * Math.sin(the) * Math.cos(phi));
        	locs[i].setY(tempLoc.getY() + r * Math.cos(the));
        	locs[i].setZ(tempLoc.getZ() + r * Math.sin(the) * Math.sin(phi));
        	i++;
    	}
    	return locs;
    }
    
    public Location[] cylloc(Location[] l, double phi, double r, double h){
    	Location[] locs = new Location[Array.getLength(l)];
    	int i = 0;
    	for(Location tempLoc : l){
    		locs[i] = tempLoc.clone();
    		locs[i].setX(tempLoc.getX() + r * Math.cos(phi));
        	locs[i].setY(tempLoc.getY() + h);
        	locs[i].setZ(tempLoc.getZ() + r * Math.sin(phi));
        	i++;
    	}
    	return locs;
    }
    
    public Location[] cubeloc(Location[] l, Location l2, double r){
    	Location[] locs = new Location[Array.getLength(l)];
    	double d = r / Math.pow(2,  0.5);
    	int i = 0;
    	for(Location tempLoc : l){
    		locs[i] = tempLoc.clone();
    		locs[i].setX(tempLoc.getX() + d * (2 * l2.getX() - 1));
        	locs[i].setY(tempLoc.getY() + d * (2 * l2.getY() - 1));
        	locs[i].setZ(tempLoc.getZ() + d * (2 * l2.getZ() - 1));
        	i++;
    	}
    	return locs;
    }
    
    public Location[] ccubeloc(Location[] l, double x, double y, double z, double r){
    	Location[] locs = new Location[Array.getLength(l)];
    	double d = r / Math.pow(2,  0.5);
    	int i = 0;
    	for(Location tempLoc : l){
    		locs[i] = tempLoc.clone();
    		locs[i].setX(tempLoc.getX() + d * (2 * x - 1));
        	locs[i].setY(tempLoc.getY() + d * (2 * y - 1));
        	locs[i].setZ(tempLoc.getZ() + d * (2 * z - 1));
        	i++;
    	}   	
    	return locs;
    }
    
    public Location[] lineloc(Location[] l, Location l2, double p){
    	Vector vect = l2.clone().toVector();
    	Location[] locs = new Location[Array.getLength(l)];
    	int i = 0;
    	for(Location tempLoc : l){
    		locs[i] = tempLoc.clone().add(vect.clone().subtract(tempLoc.clone().toVector()).multiply(p));
    		i++;
    	}
    	return locs;
    }
    
    public Location[] getLine(Location[] l, Location l2, double d){
    	Vector vect = l2.clone().toVector();
    	List<Location> locs = new ArrayList<Location>();
    	Vector v;
    	Vector tempVect;
    	
    	int k;
    	int i;
    	for(Location tempLoc : l){
    		tempVect = tempLoc.toVector();
    		k  = (int) (tempVect.distance(vect) * d);
    		v = vect.clone().subtract(tempVect).multiply(1D/k);
    		for(i = 0; i < k ; i++){
    			locs.add(tempLoc.clone().add(v.clone().multiply(i)));
    		}
    	}
    	return (Location[]) locs.toArray(new Location[locs.size()]);
    }
   
    public Location[] linkAll(Location[] loc, double d){
    	List<Location> locs = new ArrayList<Location>();
    	for(Location l1 : loc){
    		for(Location l2 : loc){
    			if(!l1.equals(l2)){
    				locs.addAll(Arrays.asList(getLine(new Location[]{l1}, l2, d)));
    			}
    		}
    	}
    	return (Location[]) locs.toArray(new Location[locs.size()]);
    }
    
    public Location[] getPoly(Location[] l, int n, double r){
    	double phi = Math.PI * 2 / (double) n;
    	Location[] locs = new Location[n*Array.getLength(l)];
    	Location loc;
    	int i = 0;
    	int j = 0;
    	for(Location tempLoc : l){
    		loc = tempLoc.clone().add(r, 0D, 0D);
    		for(i = 0; i < n; i++){
    			locs[j] = yrot(new Location[]{loc}, tempLoc, i * phi)[0];
    			j++;
    		}
    	}
    	return locs;
    }
    
    public Location[] getPolyOutline(Location[] l, Integer n, double r, double d){
    	Location[] loc = new Location[n];
    	List<Location> locs = new ArrayList<Location>();
    	int i = 0;
    	for(Location tempLoc : l){
    		loc = getPoly(new Location[]{tempLoc}, n , r);
    		for(i = 0; i < n - 1; i++){
    			locs.addAll(Arrays.asList(getLine(new Location[]{loc[i]},loc[i+1],d)));
    		}
    		locs.addAll(Arrays.asList(getLine(new Location[]{loc[i]},loc[0],d)));
    	}
    	return (Location[]) locs.toArray(new Location[locs.size()]);
    }
    
    public Location[] getHelix(Location[] l, double r, double h, double k, double d){
    	int n = (int) ( h * 2 * Math.PI * r * d);
    	double dphi = 1D / (k * r * d);
    	Location[] locs = new Location[n * Array.getLength(l)];
    	int i = 0;
    	int j = 0;
    	for(Location tempLoc : l){
    		for(j = 0; j < n; j++){
    			locs[i] = cylloc(new Location[]{ tempLoc }, j * dphi, r, j * h / n)[0];
    			i++;
    		}
    	}
    	return locs;
    	
    }
    public Location[] getCube(Location[] l, double r){
    	Location[] loc = new Location[4];
    	Location[] locs = new Location[8];
    	int i;
    	double length; 
    	for(Location tempLoc : l){
    		loc = getPoly(new Location[]{tempLoc},4,r);
    		i = 0;
    		for(Location tempLoc2: loc){
    			length = loc[0].distance(loc[1]) / 2;
    			locs[i] = tempLoc2.clone().add(0, -length, 0);
    			i++;
    			locs[i] = tempLoc2.clone().add(0, length, 0);
    			i++;
    		}
    	}
    	return locs;
    }
    
    public Location[] getCubeOutline(Location[] l, double r, double d){
    	Location[] cube = new Location[8];
    	List<Location> locs = new ArrayList<Location>();
    	for(Location tempLoc : l){
    		cube = getCube(new Location[]{tempLoc},r);
    		locs.addAll(Arrays.asList(cube));
    		locs.addAll(Arrays.asList(getLine(new Location[]{cube[0]}, cube[1], d)));
    		locs.addAll(Arrays.asList(getLine(new Location[]{cube[1]}, cube[3], d)));
    		locs.addAll(Arrays.asList(getLine(new Location[]{cube[4]}, cube[5], d)));
    		locs.addAll(Arrays.asList(getLine(new Location[]{cube[4]}, cube[6], d)));
    		locs.addAll(Arrays.asList(getLine(new Location[]{cube[1]}, cube[7], d)));
    		locs.addAll(Arrays.asList(getLine(new Location[]{cube[6]}, cube[7], d)));
    		locs.addAll(Arrays.asList(getLine(new Location[]{cube[0]}, cube[6], d)));
    		locs.addAll(Arrays.asList(getLine(new Location[]{cube[0]}, cube[2], d)));
    		locs.addAll(Arrays.asList(getLine(new Location[]{cube[4]}, cube[2], d)));
    		locs.addAll(Arrays.asList(getLine(new Location[]{cube[2]}, cube[3], d)));
    		locs.addAll(Arrays.asList(getLine(new Location[]{cube[3]}, cube[5], d)));
    		locs.addAll(Arrays.asList(getLine(new Location[]{cube[5]}, cube[7], d)));
    	}
    	return (Location[]) locs.toArray(new Location[locs.size()]);
    }
    
    public Location[] getSphereRand(Location[] l, double r, double d){
    	List<Location> locs = new ArrayList<Location>();
    	int n = (int) (4 * Math.PI * r * r * d);
    	double phi = 0D;
    	double the = 0D;
    	Random randGen = new Random();
    	for(Location tempLoc : l){
    		for(int i = 0; i < n; i++){
    			phi = randGen.nextDouble() * 2 * Math.PI;
    			the = randGen.nextDouble() * Math.PI;
    			locs.add(sphloc(new Location[]{tempLoc}, phi, the, r)[0]);
    		}
    	}
    	return (Location[]) locs.toArray(new Location[locs.size()]);
    }
    
    public Location[] getSphere(Location[] l, double r, double d){
    	List<Location> locs = new ArrayList<Location>();
    	double the = 0D;
    	double phi = 0D;
    	int n = (int) (Math.PI * r * d);
    	for(Location tempLoc : l){
    		the = 0;
    		for(int i = 0; i < n; i++){
    			phi = 0;
    			for(int j = 0; j < n * 2; j++){
    				locs.add(sphloc(new Location[]{tempLoc}, phi, the, r)[0]);
    				phi +=  Math.PI / n;
    			}
    			the += Math.PI / n;
    		}
    	}
    	return (Location[]) locs.toArray(new Location[locs.size()]);
    }
    
    
}