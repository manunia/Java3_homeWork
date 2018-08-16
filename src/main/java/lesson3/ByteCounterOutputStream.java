package lesson3;

import java.io.DataOutputStream;
import java.io.FilterOutputStream;
import java.io.OutputStream;

public class ByteCounterOutputStream extends DataOutputStream{


    /**
     * Creates a new data output stream to write data to the specified
     * underlying output stream. The counter <code>written</code> is
     * set to zero.
     *
     * @param out the underlying output stream, to be saved for later
     *            use.
     * @see FilterOutputStream#out
     */
    public ByteCounterOutputStream(OutputStream out) {
        super(out);
    }

    public int bytesWrittenSoFar() {
        return written;
    }
}
