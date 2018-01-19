/** Copyright (2016) Krishna C Tripathi. All rights reserved.
 * 
 * You are not allowed to read/copy/distribute following code without explicit written authorization from Krishna C Tripathi
 * Event after authorization this software is provided "as is" with no explicit or implicit warranties whatsoever 
 */

package org.himalay.elsys;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.lang.Exception;
import java.io.ByteArrayInputStream;
import java.io.PrintStream;
import org.himalay.msgs.runtime.Created;

import org.himalay.msgs.runtime.*;

@Created(date = "Sat Dec 09 21:56:12 EST 2017")

public class Temperature extends _Temperature { // Concrete type is Temperature
	double value = 0.0;
	@Override
	public void postRead() {
		// TODO Auto-generated method stub
		super.postRead();
		this.value = super._value / 10.0;
	}
}

// End of code