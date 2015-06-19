/*
 * Copyright (c) 2011-2015, Peter Abeles. All Rights Reserved.
 *
 * This file is part of BoofCV (http://boofcv.org).
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package boofcv.app;

import boofcv.io.UtilIO;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Outputs an EPS document describing a binary square fiducial that encodes the specified number
 *
 * @author Peter Abeles
 */
public class CreateFiducialSquareImageEPS extends BaseFiducialSquareEPS {

	public static void main(String[] args) throws IOException {

		List<String> inputPaths = new ArrayList<String>();


		double fiducialWidth = 10;
		if( args.length >= 2 ) {
			fiducialWidth = Double.parseDouble(args[0]);
			for (int i = 1; i < args.length; i++) {
				inputPaths.add(args[i]);
			}
		} else {
			inputPaths.add(UtilIO.getPathToBase()+"data/applet/fiducial/image/dog.png");
//			inputPaths.add(UtilIO.getPathToBase()+"data/applet/fiducial/image/text.png");
		}

		CreateFiducialSquareImageEPS app = new CreateFiducialSquareImageEPS();

		for( String path : inputPaths ) {
			app.addImage(path);
		}

		app.setOutputName("fiducial_image.eps");


//		app.setUnit(Unit.INCH);
		app.generateSingle(fiducialWidth);
//		app.generateGrid(2.5,1.0,2,3);
//		app.generateSingle(2.5,PaperSize.LETTER);
//		app.generateGrid(2.5,1.0,PaperSize.LETTER);
	}
}
