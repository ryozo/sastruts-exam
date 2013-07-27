package sastruts.exam.writer;

import java.io.IOException;
import java.io.Writer;

/**
 * 書き込み情報を記録するWriterです。 <br />
 * インスタンス時に書き込み記録対象の{@link Writer}クラスの実装クラスを指定してください。<br />
 * 書き込み情報を取得する場合、{@link RecordWriteWriter#getWrittedString()}メソッドを利用してください。
 * @author W.Ryozo
 * @version 1.0
 */
public class RecordWriteWriter extends Writer {

    /** 書き込み記録対象のWriter */
    private Writer recordTargetWriter;

    /** 書き込み情報を記録するStringBuilder */
    private StringBuilder recorder = new StringBuilder();

    /**
     * コンストラクタ。<br />
     * 記録対象の{@link Writer}を指定し、インスタンスを作成します。
     * @param _recordTargetWriter 書き込み記録対象のWriter
     */
    public RecordWriteWriter(Writer _recordTargetWriter) {
        recordTargetWriter = _recordTargetWriter;
    }

    @Override
    public void write(char[] cbuf, int off, int len) throws IOException {
        recorder.append(cbuf, off, len);
        recordTargetWriter.write(cbuf, off, len);
    }

    @Override
    public void write(String str) throws IOException {
        recorder.append(str);
        recordTargetWriter.write(str);
    }

    @Override
    public void write(String str, int off, int len) throws IOException {
        recorder.append(str, off, len);
        recordTargetWriter.write(str);
    }

    @Override
    public void write(int c) throws IOException {
        // TODO サロゲートペアの考慮？
        recorder.append((char) c);
        recordTargetWriter.write(c);
    }

    @Override
    public Writer append(char c) throws IOException {
        recorder.append(c);
        return recordTargetWriter.append(c);
    }

    @Override
    public Writer append(CharSequence csq) throws IOException {
        recorder.append(csq);
        return recordTargetWriter.append(csq);
    }

    @Override
    public Writer append(CharSequence csq, int start, int end) throws IOException {
        recorder.append(csq, start, end);
        return recordTargetWriter.append(csq, start, end);
    }

    @Override
    public void close() throws IOException {
        recordTargetWriter.close();
    }

    @Override
    public void flush() throws IOException {
        recordTargetWriter.flush();
    }

    /**
     * インスタンス化時から当メソッド呼び出し時までの間に書き込まれた文字列を返却する。
     * @return 書き込み文字列
     */
    public String getWrittedString() {
        return recorder.toString();
    }
}
