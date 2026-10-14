import os

def create_project_text(project_path, output_path):
    # Добавили .jsp, .css, .js, .html, .htm, .json
    extensions = (
        '.java', '.xml', '.yml', '.yaml', '.properties', 
        '.gradle', '.txt', '.sql', 
        '.jsp', '.css', '.js', '.html', '.htm', '.json'
    )
    exclude_dirs = {'.git', 'target', 'build', '.idea', 'node_modules', 'out', 'pycache'}
    
    with open(output_path, 'w', encoding='utf-8') as f:
        found_any = False
        for dirpath, dirnames, filenames in os.walk(project_path):
            # Исключаем ненужные папки
            dirnames[:] = [d for d in dirnames if d not in exclude_dirs]
            
            for filename in filenames:
                if any(filename.endswith(ext) for ext in extensions):
                    filepath = os.path.join(dirpath, filename)
                    relative_path = os.path.relpath(filepath, project_path)
                    
                    f.write(f"\n{'='*50}\n")
                    f.write(f"FILE: {relative_path}\n")
                    f.write(f"{'='*50}\n")
                    
                    try:
                        # Для веб-файлов иногда бывает другая кодировка, 
                        # поэтому добавили errors='replace' на случай сбоев
                        with open(filepath, 'r', encoding='utf-8', errors='replace') as code_file:
                            content = code_file.read()
                            f.write(content)
                            found_any = True
                    except Exception as e:
                        f.write(f"[Ошибка чтения: {e}]\n")
                        
        if not found_any:
            f.write("⚠️ НИ ОДНОГО файла с расширениями " + str(extensions) + " не найдено в проекте.\n")
            f.write("Проверьте путь и содержимое папки.")

# === ВАШИ ПУТИ ===
project_folder = r"C:\Users\ZeGeorge\IdeaProjects\posts-rest-service"
output_file =    r"C:\Users\ZeGeorge\IdeaProjects\posts-rest-service\project_dump.txt"

print("🔍 Ищу файлы в:", project_folder)
if os.path.exists(project_folder):
    create_project_text(project_folder, output_file)
    print("✅ Готово! Файл сохранён:")
    print("   ", output_file)
else:
    print("❌ ОШИБКА: Папка проекта не найдена!")
    print("Проверьте путь:", project_folder)