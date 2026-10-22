package com.example.employeecrud.employee;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.Set;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class FileStorageService {

    private static final Set<String> ALLOWED = Set.of("jpg", "jpeg", "png", "gif", "webp", "pdf", "doc", "docx");

    private final Path root;

    public FileStorageService(@Value("${app.upload-dir}") String dir) throws IOException {
        this.root = Paths.get(dir).toAbsolutePath().normalize();
        Files.createDirectories(root);
    }

    /** Saves the file under a random name and returns that name. */
    public String store(MultipartFile file) {
        String original = file.getOriginalFilename() == null ? "" : file.getOriginalFilename();
        int dot = original.lastIndexOf('.');
        String ext = dot >= 0 ? original.substring(dot + 1).toLowerCase() : "";
        if (!ALLOWED.contains(ext)) {
            throw new IllegalArgumentException("File type not allowed. Use: " + String.join(", ", ALLOWED));
        }
        String name = UUID.randomUUID() + "." + ext;
        try (InputStream in = file.getInputStream()) {
            Files.copy(in, root.resolve(name), StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException e) {
            throw new IllegalStateException("Could not save the file", e);
        }
        return name;
    }

    public Resource load(String filename) {
        try {
            Path p = root.resolve(filename).normalize();
            if (!p.startsWith(root)) return null; // blocks ../ path tricks
            Resource r = new UrlResource(p.toUri());
            return r.exists() && r.isReadable() ? r : null;
        } catch (IOException e) {
            return null;
        }
    }

    public void deleteQuietly(String filename) {
        if (filename == null || filename.isBlank()) return;
        try {
            Path p = root.resolve(filename).normalize();
            if (p.startsWith(root)) Files.deleteIfExists(p);
        } catch (IOException ignored) { }
    }
}
