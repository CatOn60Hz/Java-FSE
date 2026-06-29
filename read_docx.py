import sys
import zipfile
import xml.etree.ElementTree as ET

def extract_text(docx_file):
    try:
        with zipfile.ZipFile(docx_file) as zf:
            xml_content = zf.read('word/document.xml')
            tree = ET.XML(xml_content)
            namespace = {'w': 'http://schemas.openxmlformats.org/wordprocessingml/2006/main'}
            text = []
            for paragraph in tree.findall('.//w:p', namespace):
                texts = [node.text for node in paragraph.findall('.//w:t', namespace) if node.text]
                if texts:
                    text.append(''.join(texts))
            return '\n'.join(text)
    except Exception as e:
        return str(e)

if __name__ == '__main__':
    if len(sys.argv) > 2:
        output_file = sys.argv[2]
        with open(output_file, 'w', encoding='utf-8') as f:
            f.write(extract_text(sys.argv[1]))
    else:
        print(extract_text(sys.argv[1]))
