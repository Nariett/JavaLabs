package TaskOne;

// Конкретная фабрика для кистей визажистов
class MakeupBrushFactory implements BrushFactory {
    public Brush createBrush() {
        return new MakeupBrush();
    }
}
