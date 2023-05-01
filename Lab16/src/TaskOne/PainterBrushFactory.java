package TaskOne;

// Конкретная фабрика для кистей маляров
class PainterBrushFactory implements BrushFactory {
    public Brush createBrush() {
        return new PainterBrush();
    }
}
