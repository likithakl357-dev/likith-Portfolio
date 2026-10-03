package dev.likith.portfolio;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
import java.util.Map;

@RestController
public class PortfolioController {

    @GetMapping("/api/health")
    public Map<String, String> health() {
        return Map.of("status", "ok", "application", "Likith Charan Portfolio");
    }

    @GetMapping("/api/projects")
    public List<Map<String, String>> projects() {
        return List.of(
            project("Early Medical Diagnostics Engine for Chronic Diseases",
                "Machine Learning", "Python · Pandas · Scikit-learn",
                "A machine-learning prototype that estimates diabetes, heart disease, and kidney disease risk from health and lifestyle parameters. Intended for educational risk assessment, not medical diagnosis.",
                "https://github.com/likithakl357-dev/EARLY-MEDICAL-DIAGNOSTICS-ENGINE-FOR-CHRONIC-DISEASES"),
            project("Smart Antenna Positioning & Alignment System with Cloud Monitoring",
                "Embedded Systems", "ESP32 · Servo · LDR · DHT11 · Blynk",
                "An IoT prototype for servo-based antenna positioning with environmental sensing and Wi-Fi cloud monitoring.",
                "https://github.com/likithakl357-dev/SMART-ANTENNA-POSITIONING-ALIGNMENT-SYSTEM-WITH-CLOUD-MONITORING"),
            project("Adaptive FM Spectrum Monitoring and Signal Analysis System",
                "Signal Processing", "MATLAB · FM Signals · Spectrum Analysis",
                "A signal-analysis project focused on exploring FM radio signal characteristics and visualizing frequency spectra.",
                "https://github.com/likithakl357-dev/Design-and-Development-of-an-Adaptive-FM-Spectrum-Monitoring-and-Signal-Analysis-System"),
            project("Accelerating 5G Throughput with Hardware-Based Carrier Aggregation",
                "Communication Systems", "5G · Carrier Aggregation · Signal Processing",
                "A study and project exploring how combining frequency carriers can increase available bandwidth and data throughput.",
                "https://github.com/likithakl357-dev/Accelerating-5G-Throughput-with-Hardware-Based-Carrier-Aggregation"),
            project("Smart Fan Control System Using Temperature and Humidity Monitoring",
                "Embedded Systems", "Microcontroller · Temperature · Humidity",
                "An automated fan-control concept that uses environmental sensor readings to regulate fan operation.",
                "https://github.com/likithakl357-dev/SMART-FAN-CONTROL-SYSTEM-USING-TEMPERATURE-AND-HUMIDITIY-MONITORING-SYSETEM"),
            project("Automatic Street Light Controller Using IC 741 and CD4060",
                "Digital & Analog Electronics", "IC 741 · CD4060 · Electronic Control",
                "An electronic controller project exploring automatic lighting using comparator and timer-based circuit logic.",
                "https://github.com/likithakl357-dev/Automatic-Street-light-controller-using-IC741-and-CD4060"),
            project("Audio Playback Module Using ISD1820 for Assistive and Alert Systems",
                "PCB Design", "ISD1820 · PCB Layout · Audio Playback",
                "A PCB-based audio playback module designed around the ISD1820 voice recording and playback IC for recorded alerts and assistive applications.",
                "https://github.com/likithakl357-dev/Audio-Playback-Module-Using-ISD1820-for-Assistive-and-Alert-Systems-"),
            project("Arduino-Integrated Gas Hazard Detection and Response Network",
                "Embedded Systems", "Arduino · Gas Sensor · Alert Logic",
                "An Arduino-based prototype that monitors gas levels and triggers alerts when sensor readings indicate potentially hazardous conditions.",
                "https://github.com/likithakl357-dev/Arduino-Integrated-Gas-Hazard-Detection-and-Response-Network-"),
            project("Oracle Java SE 21",
                "Java", "Java 21 · OOP · Certification Preparation",
                "A learning repository for Java SE 21 study materials, practice, and certification preparation.",
                "https://github.com/likithakl357-dev/ORACLE-Java-SE-21")
        );
    }

    private Map<String, String> project(String title, String category, String stack, String description, String url) {
        return Map.of("title", title, "category", category, "stack", stack, "description", description, "url", url);
    }
}
