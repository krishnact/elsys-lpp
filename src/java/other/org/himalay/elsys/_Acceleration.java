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

public class _Acceleration extends ElsysDataFactory.ElsysData { // Concrete type is Acceleration

	// members variables
	// header
	public LPPHeader header;
	// x
	public byte x;
	// y
	public byte y;
	// z
	public byte z;
	// time
	

	public _Acceleration() // throws Exception
	{
		init();
	}

	private void init() {
		// Initialize header
		header = new LPPHeader();
		// Initialize x

		// Initialize y

		// Initialize z

		// Initialize time
		time = new ByteArray();
		time.setSizeType("EXTERNAL");
	}

	public int readNoHeader(DataInputStream istream) throws IOException {

		preRead();
		int retVal = 0;
		// read x
		{
			x = (byte) (istream.readByte());
			retVal += 1;
		}
		// read y
		{
			y = (byte) (istream.readByte());
			retVal += 1;
		}
		// read z
		{
			z = (byte) (istream.readByte());
			retVal += 1;
		}
		// read time
		{
			time.setSizeType("EXTERNAL");
			int iRead = getHeader().getNob() + (0);
			time.setSize(iRead);
			retVal += time.read(istream);
		}

		postRead();
		return retVal;
	}

	public int read(DataInputStream istream) throws IOException {
		preRead();
		int retVal = 0;

		// read header
		retVal += header.read(istream);
		// read x
		{
			x = (byte) (istream.readByte());
			retVal += 1;
		}
		// read y
		{
			y = (byte) (istream.readByte());
			retVal += 1;
		}
		// read z
		{
			z = (byte) (istream.readByte());
			retVal += 1;
		}
		// read time
		{
			time.setSizeType("EXTERNAL");
			int iRead = getHeader().getNob() + (0);
			time.setSize(iRead);
			retVal += time.read(istream);
		}

		postRead();
		return retVal;
	}

	public int write(DataOutputStream ostream) throws IOException {
		preWrite();
		int retVal = 0;

		{
			/** fix dependent sizes for header **/
		}

		{
			/** fix dependent sizes for time **/
			header.setNob((short) time.getSize() - (0));
		}

		// write header
		if (header != null)
			retVal += header.write(ostream);
		// write x
		ostream.writeByte(x);
		retVal += 1;
		// write y
		ostream.writeByte(y);
		retVal += 1;
		// write z
		ostream.writeByte(z);
		retVal += 1;
		// write time
		{
			retVal += time.write(ostream);
		}
		postWrite();
		return retVal;
	}

	public int dump(DumpContext dc) throws IOException {
		dc.indent();
		dc.getPs().print("_Acceleration\n");
		dc.increaseIndent();
		int retVal = 0;
		// write header
		if (header != null) {
			dc.indent();
			dc.getPs().println("header");
			retVal += header.dump(dc);
		}
		// write x
		dc.indent();
		dc.getPs().println("x=" + x + "(0x" + Integer.toHexString(x) + ")");
		// write y
		dc.indent();
		dc.getPs().println("y=" + y + "(0x" + Integer.toHexString(y) + ")");
		// write z
		dc.indent();
		dc.getPs().println("z=" + z + "(0x" + Integer.toHexString(z) + ")");
		// write time
		dc.indent();
		dc.getPs().print("time: " + time.getSize() + "(0x" + Integer.toHexString(time.getSize()) + ")\n");
		this.time.dump(dc);
		dc.decreaseIndent();
		return retVal;
	}

	// Getter for header
	// public LPPHeader getHeader()
	// {
	// return header ;
	// }

	// Setter for header
	// public void setHeader(LPPHeader val)
	// {
	// this.header= val;
	// }
	// Getter for x
	// public byte get()
	// {
	// return x ;
	// }

	// Setter for x
	// public void set(byte val)
	// {
	// this.x= val;
	// }
	// Getter for y
	// public byte get()
	// {
	// return y ;
	// }

	// Setter for y
	// public void set(byte val)
	// {
	// this.y= val;
	// }
	// Getter for z
	// public byte get()
	// {
	// return z ;
	// }

	// Setter for z
	// public void set(byte val)
	// {
	// this.z= val;
	// }
	// Getter for time
	// public ByteArray getTime()
	// {
	// return time ;
	// }

	// Setter for time
	// public void setTime(ByteArray val)
	// {
	// this.time= val;
	// }

	public void setTime(byte[] val) {
		this.time.setData(val);
	}

	public int getSize() throws IOException {
		DataOutputStream dos = new DataOutputStream(new NullStream());
		return this.write(dos);
	}

	public void setHeader(LPPHeader header) {
		this.header = header;
		this.header.setMessageType(0x03);
	}

	public LPPHeader getHeader() {
		return this.header;
	}

}

// End of code