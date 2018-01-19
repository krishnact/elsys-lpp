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

@Created(date = "Sun Dec 10 01:12:59 EST 2017")

public class LPPHeader extends BinStruct implements PublicBinMsg {

	// members variables
	// b1
	public BitField_8 b1;

	public LPPHeader() // throws Exception
	{
		init();
	}

	private void init() {
		// Initialize b1
		b1 = new BitField_8();
	}

	public int readNoHeader(DataInputStream istream) throws IOException {

		return read(istream);
	}

	public int read(DataInputStream istream) throws IOException {
		preRead();
		int retVal = 0;

		// read b1
		retVal += b1.read(istream);

		postRead();
		return retVal;
	}

	public int write(DataOutputStream ostream) throws IOException {
		preWrite();
		int retVal = 0;

		// write b1
		ostream.writeByte(b1.getValue());
		retVal += 1;
		postWrite();
		return retVal;
	}

	public int dump(DumpContext dc) throws IOException {
		dc.indent();
		dc.getPs().print("LPPHeader\n");
		dc.increaseIndent();
		int retVal = 0;
		// write b1
		{
			dc.indent();
			dc.getPs().print("nob: ");
			dc.getPs().println(BitField_8.toDisplayString(getNob_Orig(), 2));
			dc.indent();
			dc.getPs().print("messageType: ");
			dc.getPs().println(BitField_8.toDisplayString(getMessageType(), 6));
		}
		dc.decreaseIndent();
		return retVal;
	}

	// Getter for b1
	// public BitField_8 getB1()
	// {
	// return b1 ;
	// }

	// Setter for b1
	// public void setB1(BitField_8 val)
	// {
	// this.b1= val;
	// }

	public int getNob() {
		int retVal = (b1.getValue() & 0x000000c0) >> 6;
		if (retVal ==3) retVal = 4;
		return retVal;
	}

	public int getNob_Orig() {
		int retVal = (b1.getValue() & 0x000000c0) >> 6;
		return retVal;
	}
	public void setNob(int val) {
		if ( val == 3) {
			val = 4;
		}
		b1.setValue((b1.getValue() & 0xffffff3f) | ((val << 6) & 0x000000c0));
	}

	public int getMessageType() {
		return (b1.getValue() & 0x0000003f) >> 0;
	}

	public void setMessageType(int val) {
		b1.setValue((b1.getValue() & 0xffffffc0) | ((val << 0) & 0x0000003f));
	}

	public int getSize() throws IOException {
		DataOutputStream dos = new DataOutputStream(new NullStream());
		return this.write(dos);
	}

}

// End of code