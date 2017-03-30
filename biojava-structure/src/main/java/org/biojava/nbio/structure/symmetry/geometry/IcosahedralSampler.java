/*
 *                    BioJava development code
 *
 * This code may be freely distributed and modified under the
 * terms of the GNU Lesser General Public Licence.  This should
 * be distributed with the code.  If you do not have a copy,
 * see:
 *
 *      http://www.gnu.org/copyleft/lesser.html
 *
 * Copyright for this code is held jointly by the individual
 * authors.  These should be listed in @author doc comments.
 *
 * For more information on the BioJava project and its aims,
 * or to join the biojava-l mailing list, visit the home page
 * at:
 *
 *      http://www.biojava.org/
 *
 */
package org.biojava.nbio.structure.symmetry.geometry;

import javax.vecmath.AxisAngle4d;
import javax.vecmath.Quat4d;

/**
 * Represents an even coverage of quaternion space by 60 points. This grid is
 * defined by the vertices of one half of a hexacosichoron (600-cell). It
 * approximates all possible orientations to within 44.48 degrees.
 * @author Peter
 */
// This would be better named HexacosichoronSampler, since it's sampling 4D space. -SB
public final class IcosahedralSampler {
	private static Quat4d quat = new Quat4d();

	// this class cannot be instantiated
	private IcosahedralSampler() {
	}

	public static int getSphereCount() {
		return orientations.length;
	}

	public static Quat4d getQuat4d(int index) {
		Quat4d q = new Quat4d(orientations[index]); //ignores 5th element
		return q;
	}

	public static void getAxisAngle(int index, AxisAngle4d axisAngle) {
		quat.set(orientations[index]);
		axisAngle.set(quat);
	}

	//	# Orientation set c600v, number = 60, radius = 44.48 degrees
	//	# $Id: c600v.quat 6102 2006-02-21 19:45:40Z ckarney $
	//	# For more information, eee http://charles.karney.info/orientation/
	//	format quaternion
	// The fifth column gives a weighting factor. Since the 600-cell is regular, all
	// orientations cover an equal fraction of orientation space and have equal weight.
	private static double[][] orientations = {
	{1.000000000f, 0.000000000f, 0.000000000f, 0.000000000f, 1.000000f},
	{0.000000000f, 1.000000000f, 0.000000000f, 0.000000000f, 1.000000f},
	{0.000000000f, 0.000000000f, 1.000000000f, 0.000000000f, 1.000000f},
	{0.000000000f, 0.000000000f, 0.000000000f, 1.000000000f, 1.000000f},
	{0.000000000f, 0.500000000f, 0.309016994f, 0.809016994f, 1.000000f},
	{0.000000000f, -0.500000000f, 0.309016994f, 0.809016994f, 1.000000f},
	{0.000000000f, 0.500000000f, -0.309016994f, 0.809016994f, 1.000000f},
	{-0.000000000f, -0.500000000f, -0.309016994f, 0.809016994f, 1.000000f},
	{0.000000000f, 0.309016994f, 0.809016994f, 0.500000000f, 1.000000f},
	{0.000000000f, -0.309016994f, 0.809016994f, 0.500000000f, 1.000000f},
	{-0.000000000f, -0.309016994f, 0.809016994f, -0.500000000f, 1.000000f},
	{0.000000000f, 0.309016994f, 0.809016994f, -0.500000000f, 1.000000f},
	{0.000000000f, 0.809016994f, 0.500000000f, 0.309016994f, 1.000000f},
	{-0.000000000f, 0.809016994f, -0.500000000f, -0.309016994f, 1.000000f},
	{0.000000000f, 0.809016994f, -0.500000000f, 0.309016994f, 1.000000f},
	{0.000000000f, 0.809016994f, 0.500000000f, -0.309016994f, 1.000000f},
	{0.500000000f, 0.000000000f, 0.809016994f, 0.309016994f, 1.000000f},
	{-0.500000000f, 0.000000000f, 0.809016994f, 0.309016994f, 1.000000f},
	{-0.500000000f, -0.000000000f, 0.809016994f, -0.309016994f, 1.000000f},
	{0.500000000f, 0.000000000f, 0.809016994f, -0.309016994f, 1.000000f},
	{0.309016994f, 0.000000000f, 0.500000000f, 0.809016994f, 1.000000f},
	{-0.309016994f, 0.000000000f, 0.500000000f, 0.809016994f, 1.000000f},
	{0.309016994f, 0.000000000f, -0.500000000f, 0.809016994f, 1.000000f},
	{-0.309016994f, -0.000000000f, -0.500000000f, 0.809016994f, 1.000000f},
	{0.809016994f, 0.000000000f, 0.309016994f, 0.500000000f, 1.000000f},
	{0.809016994f, -0.000000000f, -0.309016994f, -0.500000000f, 1.000000f},
	{0.809016994f, 0.000000000f, -0.309016994f, 0.500000000f, 1.000000f},
	{0.809016994f, 0.000000000f, 0.309016994f, -0.500000000f, 1.000000f},
	{0.309016994f, 0.809016994f, 0.000000000f, 0.500000000f, 1.000000f},
	{-0.309016994f, 0.809016994f, 0.000000000f, 0.500000000f, 1.000000f},
	{-0.309016994f, 0.809016994f, -0.000000000f, -0.500000000f, 1.000000f},
	{0.309016994f, 0.809016994f, 0.000000000f, -0.500000000f, 1.000000f},
	{0.809016994f, 0.500000000f, 0.000000000f, 0.309016994f, 1.000000f},
	{0.809016994f, -0.500000000f, -0.000000000f, -0.309016994f, 1.000000f},
	{0.809016994f, -0.500000000f, 0.000000000f, 0.309016994f, 1.000000f},
	{0.809016994f, 0.500000000f, 0.000000000f, -0.309016994f, 1.000000f},
	{0.500000000f, 0.309016994f, 0.000000000f, 0.809016994f, 1.000000f},
	{-0.500000000f, 0.309016994f, 0.000000000f, 0.809016994f, 1.000000f},
	{0.500000000f, -0.309016994f, 0.000000000f, 0.809016994f, 1.000000f},
	{-0.500000000f, -0.309016994f, -0.000000000f, 0.809016994f, 1.000000f},
	{0.809016994f, 0.309016994f, 0.500000000f, 0.000000000f, 1.000000f},
	{0.809016994f, -0.309016994f, -0.500000000f, -0.000000000f, 1.000000f},
	{0.809016994f, -0.309016994f, 0.500000000f, 0.000000000f, 1.000000f},
	{0.809016994f, 0.309016994f, -0.500000000f, 0.000000000f, 1.000000f},
	{0.500000000f, 0.809016994f, 0.309016994f, 0.000000000f, 1.000000f},
	{-0.500000000f, 0.809016994f, 0.309016994f, 0.000000000f, 1.000000f},
	{-0.500000000f, 0.809016994f, -0.309016994f, -0.000000000f, 1.000000f},
	{0.500000000f, 0.809016994f, -0.309016994f, 0.000000000f, 1.000000f},
	{0.309016994f, 0.500000000f, 0.809016994f, 0.000000000f, 1.000000f},
	{-0.309016994f, 0.500000000f, 0.809016994f, 0.000000000f, 1.000000f},
	{0.309016994f, -0.500000000f, 0.809016994f, 0.000000000f, 1.000000f},
	{-0.309016994f, -0.500000000f, 0.809016994f, -0.000000000f, 1.000000f},
	{0.500000000f, 0.500000000f, 0.500000000f, 0.500000000f, 1.000000f},
	{0.500000000f, -0.500000000f, -0.500000000f, -0.500000000f, 1.000000f},
	{0.500000000f, -0.500000000f, 0.500000000f, 0.500000000f, 1.000000f},
	{0.500000000f, 0.500000000f, -0.500000000f, 0.500000000f, 1.000000f},
	{0.500000000f, 0.500000000f, 0.500000000f, -0.500000000f, 1.000000f},
	{0.500000000f, 0.500000000f, -0.500000000f, -0.500000000f, 1.000000f},
	{0.500000000f, -0.500000000f, 0.500000000f, -0.500000000f, 1.000000f},
	{0.500000000f, -0.500000000f, -0.500000000f, 0.500000000f, 1.000000f},
	};
}
