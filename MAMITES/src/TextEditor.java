
public class TextEditor {
    private String text;

    public TextEditor(String initialText) {
        this.text = initialText;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public void append(String newText) {
        this.text += newText;
    }

    public void delete(int n) {
        if (n <= text.length()) {
            this.text = this.text.substring(0, this.text.length() - n);
        }
    }

    void undo() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
