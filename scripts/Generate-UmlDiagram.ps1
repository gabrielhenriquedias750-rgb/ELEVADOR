Add-Type -AssemblyName System.Drawing

$outputPath = Join-Path $PSScriptRoot "..\\docs\\uml\\elevador-classe.png"
$bitmap = New-Object System.Drawing.Bitmap 1200, 780
$graphics = [System.Drawing.Graphics]::FromImage($bitmap)

$graphics.SmoothingMode = [System.Drawing.Drawing2D.SmoothingMode]::AntiAlias
$graphics.Clear([System.Drawing.Color]::White)

$black = [System.Drawing.Brushes]::Black
$pen = New-Object System.Drawing.Pen([System.Drawing.Color]::Black, 2)
$titleFont = New-Object System.Drawing.Font("Consolas", 18, [System.Drawing.FontStyle]::Bold)
$classFont = New-Object System.Drawing.Font("Consolas", 14, [System.Drawing.FontStyle]::Bold)
$textFont = New-Object System.Drawing.Font("Consolas", 11)
$arrowFont = New-Object System.Drawing.Font("Consolas", 10)

$graphics.DrawString("Diagrama de Classe UML - Atividade Elevador", $titleFont, $black, 290, 20)

$elevadorRect = New-Object System.Drawing.Rectangle 90, 110, 420, 500
$mainRect = New-Object System.Drawing.Rectangle 650, 220, 260, 120

$graphics.DrawRectangle($pen, $elevadorRect)
$graphics.DrawLine($pen, 90, 160, 510, 160)
$graphics.DrawLine($pen, 90, 305, 510, 305)

$graphics.DrawString("Elevador", $classFont, $black, 250, 128)

$atributos = @(
    "- andarMinimo: int",
    "- andarMaximo: int",
    "- andarAtual: int",
    "- portaAberta: boolean"
)

$metodos = @(
    "+ Elevador(andarMinimo: int, andarMaximo: int)",
    "+ subir(): void",
    "+ descer(): void",
    "+ abrirPorta(): void",
    "+ fecharPorta(): void",
    "+ isPortaAberta(): boolean",
    "+ getAndarAtual(): int",
    "+ getStatusPorta(): String",
    "+ getAndarMinimo(): int",
    "+ getAndarMaximo(): int"
)

$y = 180
foreach ($atributo in $atributos) {
    $graphics.DrawString($atributo, $textFont, $black, 110, $y)
    $y += 28
}

$y = 325
foreach ($metodo in $metodos) {
    $graphics.DrawString($metodo, $textFont, $black, 110, $y)
    $y += 24
}

$graphics.DrawRectangle($pen, $mainRect)
$graphics.DrawLine($pen, 650, 270, 910, 270)
$graphics.DrawString("Main", $classFont, $black, 750, 238)
$graphics.DrawString("+ main(args: String[]): void", $textFont, $black, 670, 290)

$graphics.DrawLine($pen, 510, 275, 650, 275)
$graphics.DrawLine($pen, 640, 270, 650, 275)
$graphics.DrawLine($pen, 640, 280, 650, 275)
$graphics.DrawString("cria e utiliza", $arrowFont, $black, 545, 245)

$graphics.Dispose()
$bitmap.Save($outputPath, [System.Drawing.Imaging.ImageFormat]::Png)
$bitmap.Dispose()
$pen.Dispose()
$titleFont.Dispose()
$classFont.Dispose()
$textFont.Dispose()
$arrowFont.Dispose()
